package com.ft.myapplication2.rxjava;

import com.ft.myapplication2.rxjava.student.Course;
import com.ft.myapplication2.rxjava.student.Student;
import com.ft.myapplication2.utils.L;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**变换
 *RxJava提供了对事件序列进行变换的支持，这是他核心的功能之一。
 *所谓变换就是将事件中的对象或整个序列进行加工处理，转换成不同的事件或事件序列
 * Created by FT_ZSS on 2016/8/3.
 */
public class RxJava_Scheduler_Demo_Student implements IRxJava {

    private static final String TAG = "RxJava_Scheduler_Demo_Student";
    private Student[] students = new Student[3];

    public RxJava_Scheduler_Demo_Student(){

        initStudent();
    }

    @Override
    public void test() {

    }

    /**
     * 要求打印每一个学生的名字（一般实现）
     */
    public void testPrintStudentName_General(){

        for (Student student:students){

            L.d(TAG,"Student Name:" + student.getName());
        }
    }


    /**
     * 要求打印每一个学生的名字（RxJava实现）
     */
    public void testPrintStudentName_RxJava(){

        Observable.from(students)
        .map(new Func1<Student, String>() {
            @Override
            public String call(Student student) {
                return student.getName();
            }
        })
        .subscribe(new Action1<String>() {
            @Override
            public void call(String name) {
                L.d(TAG,name);
            }
        });
    }

    /**
     * 要求打印每一个学生每一个课程的名字(一般实现)
     */
    public void testPrintStudentCoursesName_General(){

        for (Student student:students){
            L.d(TAG,"Student Name:" + student.getName());
            for (Course course:student.getCourses()){
                L.d(TAG,"Course Name:"+ course.getName());
            }
        }
    }

    /**
     * 要求打印每一个学生每一个课程的名字（Rxjava实现）
     */
    public void testPrintStudentCoursesName_RxJava_For(){
        Observable.from(students)
                .subscribe(new Action1<Student>() {
                    @Override
                    public void call(Student student) {
                        L.d(TAG,"Student Name:" + student.getName());
                        List<Course> courses = student.getCourses();
                        for (Course course:courses){
                            L.d(TAG,"Course Name:" + course.getName());
                        }
                    }
                });
    }


    /**
     * 要求打印每一个学生每一个课程的名字(RxJava flatMap实现)
     * 用 map() 显然是不行的，因为 map() 是一对一的转化，而我现在的要求是一对多的转化。那怎么才能把一个 Student 转化成多个 Course 呢？
     *这个时候，就需要用 flatMap() 了
     */
    public void testPrintStudentCoursesName_RxJava_flatMap(){

        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        L.d(TAG,"Student Name:" + student.getName());
                        return Observable.from(student.getCourses());
                    }
                }).subscribe(new Subscriber<Course>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Course course) {

                L.d(TAG,"Course Name:" + course.getName());
            }
        });

    }

    private void initStudent(){

        Course eglish = new Course();
        eglish.setName("Eglish");

        Course chinese = new Course();
        chinese.setName("Chinese");

        Course math = new Course();
        math.setName("Math");

        students[0] = new Student();
        students[0].setName("xiao zhang");
        students[0].setCourses(eglish);
        students[0].setCourses(chinese);
        students[0].setCourses(math);

        students[1] = new Student();
        students[1].setName("xiao li");
        students[1].setCourses(eglish);
        students[1].setCourses(chinese);
        students[1].setCourses(math);

        students[2] = new Student();
        students[2].setName("xiao liu");
        students[2].setCourses(eglish);
        students[2].setCourses(chinese);
        students[2].setCourses(math);
    }
}

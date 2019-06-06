package by.training.thread.task18_countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Student extends Thread {
    private Integer idStudent;
    private List<Task> taskList;
    private CountDownLatch countDownLatch;

    public Student(Integer id, int numberTasks) {
        idStudent = id;
        countDownLatch = new CountDownLatch(numberTasks);
        taskList = new ArrayList<>(numberTasks);
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public void run() {
        int i = 0;
        for (Task inWork : taskList) {
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inWork.setAnswer("Answer #" + ++i);
            System.out.println("Answer #" + i + " from " + idStudent);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float averageMark = 0;
        for (Task inWork : taskList) {
            averageMark += inWork.getMark();
        }
        averageMark /= taskList.size();
        System.out.println("Student " + idStudent + " : " + averageMark);
    }
}

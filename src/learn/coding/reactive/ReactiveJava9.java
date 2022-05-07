package learn.coding.reactive;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpHelper {
    private EmpHelper(){}
    public static List<Employee> getEmps() {
        return Arrays.asList(new Employee(1, "Vinoth"), new Employee(2, "Nirmal")
                , new Employee(3, "Jaya"), new Employee(4, "Manoharan"));
    }
}

class MySubscriber implements Subscriber<Employee> {
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Subscription subscription;

    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        logger.log(Level.INFO, "Subscribed");
        this.subscription = subscription;
        this.subscription.request(1);
        logger.log(Level.INFO, "On Subscribe requested 1 item");
    }

    @Override
    public void onNext(Employee item) {
        logger.log(Level.INFO, "Processing Employee {0}", item);
        counter++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        logger.log(Level.INFO, "Some error happened");
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        logger.log(Level.INFO, "All are processed");
    }

    public int counter(){
        return counter;
    }
}

public class ReactiveJava9 {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        // Create Publisher
        SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

        // Register Subscriber
        MySubscriber subscriber = new MySubscriber();
        publisher.subscribe(subscriber);

        List<Employee> employeeList = EmpHelper.getEmps();

        logger.log(Level.INFO, "Publishing item to Subscriber");
        employeeList.forEach(publisher::submit);

        // Wait till all messages are processed
        while(employeeList.size() != subscriber.counter()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                logger.log(Level.INFO, "Interrupted!", e);
                Thread.currentThread().interrupt();
            }
        }

        publisher.close();

        logger.log(Level.INFO, "Completed");

    }
}

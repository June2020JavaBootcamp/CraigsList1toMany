package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JobRepository jobRepository;

    @Override
    public void run (String...strings) throws Exception{
        User userX = new User();
        userX.setUserName("Ingrid");

        Job job1 = new Job();
        job1.setJobTitle("Data Entry");
        job1.setDescription("enter data all day");
        job1.setPostedDate("7/27/20");
        job1.setPhone("301-871-0418");
        job1.setUser(userX);

        Job job2 = new Job();
        job2.setJobTitle("Jr Software Developer");
        job2.setDescription("Develop all day");
        job2.setPostedDate("7/20/20");
        job2.setPhone("301-871-0418");
        job2.setUser(userX);

        Job job3 = new Job();
        job3.setJobTitle("Software Engineer");
        job3.setDescription("engineer data all day");
        job3.setPostedDate("7/01/20");
        job3.setPhone("301-871-0418");
        job3.setUser(userX);

        userRepository.save(userX);
        jobRepository.save(job1);
        jobRepository.save(job2);
        jobRepository.save(job3);

        User user1 = new User();
        user1.setUserName("Alex");

        Job job4 = new Job();
        job4.setJobTitle("Admin Assistant");
        job4.setDescription("Help with daily office tasks");
        job4.setPostedDate("7/23/20");
        job4.setPhone("301-933-3399");
        job4.setUser(user1);

        Job job5 = new Job();
        job5.setJobTitle("Jr Technician");
        job5.setDescription("Help with technical things");
        job5.setPostedDate("6/20/20");
        job5.setPhone("301-933-339");
        job5.setUser(user1);

        Job job6 = new Job();
        job6.setJobTitle("Car Mechanic");
        job6.setDescription("Fix Cars all day");
        job6.setPostedDate("6/01/20");
        job6.setPhone("301-933-339");
        job6.setUser(user1);

        userRepository.save(user1);
        jobRepository.save(job4);
        jobRepository.save(job5);
        jobRepository.save(job6);

        User user2 = new User();
        user2.setUserName("Samantha");

        Job job7 = new Job();
        job7.setJobTitle("Warehouse Assistant");
        job7.setDescription("Help with daily warehouse tasks");
        job7.setPostedDate("8/23/20");
        job7.setPhone("301-453-0918");
        job7.setUser(user2);

        Job job8 = new Job();
        job8.setJobTitle("Customer Service Representative");
        job8.setDescription("Handle customer calls daily");
        job8.setPostedDate("7/04/20");
        job8.setPhone("301-453-0918");
        job8.setUser(user2);

        Job job9 = new Job();
        job9.setJobTitle("Cafeteria Worker");
        job9.setDescription("Help prepare meals for cafeteria");
        job9.setPostedDate("7/02/20");
        job9.setPhone("301-453-0918");
        job9.setUser(user2);

        userRepository.save(user2);
        jobRepository.save(job7);
        jobRepository.save(job8);
        jobRepository.save(job9);

        User user3 = new User();
        user3.setUserName("Frank");

        Job job10 = new Job();
        job10.setJobTitle("Field Tech");
        job10.setDescription("Help in the field");
        job10.setPostedDate("7/23/20");
        job10.setPhone("301-987-2341");
        job10.setUser(user3);

        Job job11 = new Job();
        job11.setJobTitle("Customer Service Rep");
        job11.setDescription("Handle customer calls daily");
        job11.setPostedDate("8/04/20");
        job11.setPhone("301-987-2341");
        job11.setUser(user3);

        Job job12 = new Job();
        job12.setJobTitle("Manager");
        job12.setDescription("Manage people at a restaurant");
        job12.setPostedDate("7/29/20");
        job12.setPhone("301-987-2341");
        job12.setUser(user3);

        userRepository.save(user3);
        jobRepository.save(job10);
        jobRepository.save(job11);
        jobRepository.save(job12);

    }
}

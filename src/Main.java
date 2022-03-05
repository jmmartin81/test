import com.jmm.sorts.example.QuickSortHelper;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );
    public static void main(String[] args) {
//        LOGGER.info("STARTING...");
//        int[] myArray = {10,1,4,3,6,5,9,8,7,2};
//        MergeSortHelper.sort(myArray,10);
//        System.out.println( Arrays.toString(myArray)  );
//        LOGGER.info("Finished");




        Random r = new Random();
        int size= 100000000;
    int [] array = new int[size];
        int last = 0;

        Instant start = Instant.now();
        LOGGER.info("generating...");
        for (int i = 0 ; i < array.length; i++){
           array[i] =  r.nextInt(0,size);
        }
//        int [] array =  r.ints(0, size)
//                .distinct()
//                .limit(size)
//                .toArray();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toSeconds();
        LOGGER.info("done: " + timeElapsed);
       // System.out.println("Before" +  Arrays.toString(array)  + " size: " + array.length);
        start = Instant.now();
        QuickSortHelper.sort(array,0,array.length -1);
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toSeconds();
        LOGGER.info("Finish QuickSort: " + timeElapsed);
       // System.out.println("after" +  Arrays.toString(array)  + " size: " + array.length);


//        LOGGER.info("Second STARTING...");
//        List<Test> myTests= new ArrayList<>(size);
//        Test tChoosen = null;
//        start = Instant.now();
//        for (int i = 0; i< size;i++){
//            Test t  = new Test();
//            t.setCode(t.generateRndString());
//            t.setName(t.generateRndString());
//            t.setPriority(r.nextInt(0,size));
//            t.setProcessDate(new Date());
//            if (tChoosen == null){
//                tChoosen = new Test();
//                tChoosen.setPriority(t.getPriority());
//                tChoosen.setCode(t.getCode());
//                tChoosen.setName(t.getName());
//                tChoosen.setProcessDate(t.getProcessDate());
//            }
//            myTests.add(t);
//        }
//        finish = Instant.now();
//        timeElapsed = Duration.between(start, finish).toMillis();
//        LOGGER.info("init: " + timeElapsed);
//
//        start = Instant.now();
//        Collections.sort(myTests,Comparator.comparingInt(Test::getPriority) );
//        finish = Instant.now();
//        timeElapsed = Duration.between(start, finish).toMillis();
//        LOGGER.info("sorting: " + timeElapsed);
//      // MergeSortHelper.sort(array,size);
//        start = Instant.now();
//        int index =  Collections.binarySearch(myTests,tChoosen,Comparator.comparingInt(Test::getPriority));
//        finish = Instant.now();
//        timeElapsed = Duration.between(start, finish).toMillis();
//        LOGGER.info("binary: " + timeElapsed);
//        LOGGER.info("priority :"+  myTests.get(index).getPriority() +" name:" + myTests.get(index).getName());
//// CODE HERE
//
//        final int  finalTCChoose = tChoosen.getPriority();
//        Predicate<Test> myPredicate = test-> test.getPriority() == finalTCChoose;
//
//        start = Instant.now();
//        Test search = myTests.stream().filter(myPredicate).findFirst().orElse(new Test());;
//        finish = Instant.now();
//        timeElapsed = Duration.between(start, finish).toMillis();
//        LOGGER.info("filter: " + timeElapsed);
//        LOGGER.info("priority :"+  search.getPriority() +" name:" + search.getName());





    }

    public static class Test {
        private int priority;
        private String name;
        private String code;
        private Date processDate;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Date getProcessDate() {
            return processDate;
        }

        public void setProcessDate(Date processDate) {
            this.processDate = processDate;
        }

        String generateRndString(){
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            return generatedString;
        }
    }



}

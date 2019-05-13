package org.katheer.test;

import org.katheer.bean.Student;
import org.katheer.bean.StudentCollection;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student("Abdul Katheer", "IT", 9.49f);
        Student s2 = new Student("Dhanalakshmi", "IT", 9.28f);
        Student s3 = new Student("Hari", "CSE", 8.88f);

        StudentCollection studentCollection = new StudentCollection();

        studentCollection.getStudentList().add(s1);
        studentCollection.getStudentList().add(s2);
        studentCollection.getStudentList().add(s3);

        studentCollection.getStudentMap().put("S101", s1);
        studentCollection.getStudentMap().put("S102", s2);
        studentCollection.getStudentMap().put("S103", s3);

        StandardEvaluationContext context = new StandardEvaluationContext(studentCollection);
        ExpressionParser parser = new SpelExpressionParser();

        //Accessing elements from List using indices
        System.out.println(parser.parseExpression("studentList[0]").getValue(studentCollection));
        System.out.println(parser.parseExpression("studentList[1]").getValue(studentCollection));
        System.out.println(parser.parseExpression("studentList[2]").getValue(studentCollection));
        //System.out.println(parser.parseExpression("studentList[3]").getValue(studentCollection));
        //System.out.println(parser.parseExpression("studentList[4]").getValue(studentCollection));

        //Accessing elements from List based on condition
        System.out.println(parser.parseExpression("studentList.?[dept == " +
                "'IT']").getValue(studentCollection));
        System.out.println(parser.parseExpression("studentList.?[cgpa > 9.0]").getValue(studentCollection));
        System.out.println(parser.parseExpression("studentList.?[dept == " +
                "'CSE']").getValue(studentCollection));

        //Accessing elements from Map based on key
        System.out.println(parser.parseExpression("studentMap['S101']").getValue(studentCollection));
        System.out.println(parser.parseExpression("studentMap['S104']").getValue(studentCollection));
        
    }
}

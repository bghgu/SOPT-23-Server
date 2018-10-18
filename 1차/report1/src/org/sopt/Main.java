package org.sopt;

import org.sopt.model.Department;
import org.sopt.model.Professor;
import org.sopt.model.Student;
import org.sopt.model.University;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        final ArrayList<Student> studentList = new ArrayList<>();
        final ArrayList<University> universities = new ArrayList<>();
        final ArrayList<Department> departments = new ArrayList<>();
        final ArrayList<Professor> professors = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            studentList.add(new Student());
            universities.add(new University());
            departments.add(new Department());
            professors.add(new Professor());
        }

        for(final University u : universities) {
            System.out.println(u.toString());
        }

        for(final Student s : studentList) {
            System.out.println(s.toString());
        }

        for(final Department d : departments) {
            System.out.println(d.toString());
        }

        for(final Professor p : professors) {
            System.out.println(p.toString());
        }
    }
}

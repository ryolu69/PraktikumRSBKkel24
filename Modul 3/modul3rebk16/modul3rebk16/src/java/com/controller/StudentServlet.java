/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.StudentDAOLocal;
import com.model.Student;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author WIN 10
 */
@WebServlet(name = "StudentServlet")
public class StudentServlet extends HttpServlet {
    @EJB
    private StudentDAOLocal studentDao;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    String action = request.getParameter("action");
    String studentIdStr = request.getParameter("studentId");
    int studentId=0;
    if(studentIdStr!=null && !studentIdStr.equals("")){
        studentId=Integer.parseInt(studentIdStr);
    }
    String firstname = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    Student student = new Student(studentId, firstname, lastname);
    if("Add".equalsIgnoreCase(action)){
        studentDao.addStudent(student);
    }else if("Edit".equalsIgnoreCase(action)){
        studentDao.editStudent(student);
    }else if("Delete".equalsIgnoreCase(action)){
        studentDao.deleteStudent(studentId);
    }else if("Search".equalsIgnoreCase(action)){
        student = studentDao.getStudent(studentId);
    }
    request.setAttribute("student", student);
    request.setAttribute("allStudents", studentDao.getAllStudents());
    request.getRequestDispatcher("home.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
    return "Short description";
    }// </editor-fold>
}


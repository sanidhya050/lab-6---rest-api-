package student_controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import student_entity.Student;
import student_service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService StudentService;

	/*
	 * find out the Resuorce uri /books/showFormforAdd /books/ShowFormForUpdate
	 * /books/Delete /books/Save /books/list--> display all books ( find out
	 * anythimg comman uri from all mapping and put on class level )
	 * 
	 * 
	 */

	@RequestMapping("/list") // print all records from the table
	public String ListStudents(Model theModel) {
		List<Student> theStudents = StudentService.FindAll();
		theModel.addAttribute("Students", theStudents);
		return "list-Students";
	}

	@RequestMapping("/ShowFormForAdd") // insert new records into the table
	public String ShowFormForAdd(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("Student", theStudent);
		return "Student-form";
	}

	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute("Student") Student theStudent) {

		// save
		StudentService.save(theStudent);
		return "redirect:/Students/list";

	}

	@RequestMapping("/delete") // delete exisiting records from the table
	public String delete(@RequestParam("StudentId") long theId) {

		StudentService.DeleteById(theId);
		return "redirect:/books/list";

	}

	@RequestMapping("/showFormForUpdate") // updating the existing records fro the table
	public String showFormForUpdate(@RequestParam("StudentId") Long theId, Model theModel) {

		Student theStudent = StudentService.findById(theId);
		theModel.addAttribute("Student", theStudent);
		return "student-form-update";

	}
	@RequestMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		
		if(user != null ) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access page!");
		}else {
			model.addObject("msg", "You do not hve permission tp access this page !");
		}
		
		model.setViewName("403");
		return model ; 
	}

}

package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
//	List<Course> list;
	
	
	
	/*public CourseServiceimpl() {
	
		list=new ArrayList<>();
		list.add(new Course(145,"java core course","Contains basics of java"));
		list.add(new Course(4343,"spring boot course","creating rest api using springboot"));
		
	}*/
	
	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseId)
	{
	/*	Co
	 * urse c=null;
		
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;*/
		
		return courseDao.getOne(courseId);
	}



	@Override
	public List<Course> getCourses() 
	{
		// TODO Auto-generated method stub
		//return list;
		return courseDao.findAll();
		
		
		
	}

	@Override
	public Course addCourse(Course course) 
	{
		//list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) 
	{	
		//list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
        Course entity=courseDao.getOne(courseId);
        courseDao.delete(entity);
	}
	

	@Override
	public Course UpdateCourse(Course course) 
	{
		
		/*list.forEach(e ->
		{
			if(e.getId()==course.getId())
			{
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
			
		});*/
		courseDao.save(course);
		return course;
	}
	

}

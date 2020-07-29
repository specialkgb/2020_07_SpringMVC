package com.biz.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biz.hello.service.HelloService;
import com.biz.hello.service.ScoreService;

/*
 * @RestController
 * SpringFramework 4.x 이상에서 지원되는 새로운 Controller
 */
@RestController
public class HelloRestController {
	
	/* @Autowired
	 * Spring Framework 프로젝트에서 @Annotation으로 설정된 클래스들을 객체로 생성한
	 * 컨테이너가 있으며
	 * 컨테이너에 저장된 객체를 찾아서 선언된 객체에 주입하여 초기화, 사용할 수 있도록 해준다.
	 * 객체를 생성하기 위해서 생성자를 만들 필요가 없어진다.
	 */
	
	// DI. HelloService interface를 implements한 클래스가 있는지 확인하고 있으면 그 클래스를 통째로 hService에 담아버림.
	@Autowired
	private HelloService hService;
	
	// DI. ScoreService 라는 클래스가 있는지 확인하고 있으면 그 클래스를 통째로 sService에 담아버림.
	// 우리는 여태 클래스나 메소드를 사용할땐 꼭 new << 이런식으로 초기화를 했었는데 @Autowired는 지가 알아서 다 해줌.
	// 쓰기면 하면 됌.
	@Autowired
	private ScoreService sService;
	
	@Autowired
	private HomeController hController;
	
	
	
	/*
	표준 자바코드에서 사용하는 (기본) 생성자
	// 사용자가 요청할 때마다 객체를 생성하여 과부하가 걸림.
	public HelloRestController() {
		hService = new HelloServiceImpl1();
		sService = new ScoreService();
	}
	*/
	
	// Spring framework에서 권장하는 생성자
	// 서버가 시작될 때 최초로 한번만 객체를 생성하여 초기화를 한 뒤 사용자들이 공유함.
	/*
	 * Spring 프로젝트에서는 외부의 클래스를 객체로 만들 때
	 * 직접 new 생성자를 사용하여 만들지 않는다.
	 * 
	 * 프로젝트가 시작될 때 @Annotation이 붙어있는 모든 클래스는 이미 객체로 생성되어
	 * Container에 저장되어 있다.
	 * 
	 * 다른 클래스를 객체로 생성하여 사용이 필요한 곳이 있으면
	 * Container에서 객체를 꺼내서 직접 주입해 준다.
	 * 
	 * DI(Dependency Inject) : 의존성 주입, 필요한 곳에 주입, 필요한 곳에 가져다 주기
	 * IOC(Inversion of Control) : 제어의 역전 이라고 한다.
	 */
//	public HelloRestController(HelloService hService, ScoreService sService) {
//		
//		this.hService = hService;
//		this.sService = sService;
//	}
	
	
	// localhost:8080/hello/rest 라고 요청을 하면 응답하라
	@RequestMapping(value="/rest")
	public String rest(Model model) {
		
		model.addAttribute("myname", "korea");
		
		return "Republic of Korea";
		
	}
	
	@RequestMapping(value="/null")
	public String mnull(Model model) {
		
		model.addAttribute("myname", "korea");
		
		return null;
		
	}
	
	// 덧셈한 결과를 문자열로 바꿔서 return;
	@RequestMapping(value="/int")
	public String hello() {
		int ret = hService.add(20, 40);
		return ret + "";
	}
	/*
	 * NullPointerException
	 * 클래스를 객체로 만들어서 method를 호출하는 경우
	 * 가장 많이 발생하는 exception 중 하나
	 * 
	 * 클래스를 객체로 선언은 했으나 초기화, 생성을 하지 않은 경우
	 * 이 메서드에서 intList = new ArrayList<Integer>(); 를 생략하면
	 * List<Integer> intList = null; 에서 intList가 선언은 되었지만
	 * 초기화가 되지 않아서
	 * 
	 * intList.add(100);를 실행했을 때 NullPointerException이 발생한다.
	 */
	public void nullPointer() {
		List<Integer> intList;
		intList = new ArrayList<Integer>();
		intList.add(100);
	}
}

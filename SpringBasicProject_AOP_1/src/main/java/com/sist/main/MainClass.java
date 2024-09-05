package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MaDAO;

/*
 * 	     1. DI => Ŭ������ Ŭ���� ���� ���� : �޴��� (����) => Ŭ���� ������ ���� ����
 *          1) XML ��� : Spring4 => �������� �����ӿ�ũ(�ǹ�)
 *          2) Annotation��� => ���̺귯�� Ŭ������Ͻÿ� ����� �޾Ƽ� ó��
 *                             =========
 *                             ������̼� ������ �ȵ�
 *          3) XML + Annotation
 *             ================ XML : ���̺귯�� ��Ͻ� (MyBatis , ����)
 *                     ����� ���Ǵ� Annotation���� ����
 *                     => ������Ʈ���� �������� ��� => XML
 *                     => �����ڸ��� => ������̼����� ����
 *          ===========================================================
 *          4) ���� �ڹٸ� �̿�
 *             ============
 *             
 *             XML : �������� Ŭ���� ������ (����~�Ҹ�)
 *              = �Ѱ��� Ŭ������ ���
 *                <bean id="" class="" scope="">
 *                      ===   =====    ======
 *                        			   | �̱���(�Ѱ��� ��ü�� �̿��ϴ� ���)
 *                                        prototype
 *                            | �޸� �Ҵ��� Ŭ���� ���� (�ݵ�� ��Ű������)
 *                      | ������ (�ߺ��� �� ���� , Ŭ���� ��ü�� ã�� ��쿡 ���)
 *                 => �ڹ� ����
 *                    @Bean("id")
 *              = ��Ű�� ���� ���
 *                <context:component-scan base-package="��Ű����">
 *                   => �ڹ� ���� : @ComponentScan(basePackage={""})
 *                   => <mybatis-spring base-package="">
 *                      => �ڹ� ���� : @MapperScan(basePackage={""})
 *                   => Spring-Boot:Framework�� ����
 *                      ===========
 *                         => application.properties
 *                            server.port=80
 *                         => application.yml
 *                            server:
 *                               port:80
 *                   => �������� �޸� �Ҵ�
 *                      Ŭ��������
 *                      @Component : �Ϲ� Ŭ����
 *                      @Repository : DAO
 *                      @Service : DAO������ ���� : BI
 *                      =======================================================
 *                      @Controller : Model => Ŭ���� ������ ������ �Ǹ� ��ó���� �ȵȴ�
 *                                    forward
 *                                    redirect
 *                                    ȭ�� ���� ����
 *                      @RestController : Model => ȭ�� ������ �ƴϴ�
 *                      						   JSON���� => �ڹٽ�ũ��Ʈ ����
 *                                        => GET => SELECT
 *                                        => POST => UPDATE
 *                                        => PUT => INSERT
 *                                        => DELETE => DELETE
 *                      @ControllerAdvice : ���������� ����ó��
 *                      ======================================================== �������� ��밡��
 *                      *** �������� ��ϵ� ��ü ã�� => getBean("id��")
 *                      *** ���������� ��ϵ� Ŭ������ ���� : �����̳�
 *                                  BeanFactory
 *                                  	|
 *                                  ApplicationContext
 *                                  	|
 *                             ------------------------------------
 *                             |								  |
 *                     AnnotationConfigApplicationContext   WebApplicationContext(MVC)
 *       2. AOP => �������� ���Ǵ� Ŭ������ ����� ��Ƽ� ó�� => �ڵ� ȣ��
 *          -- Aspect : �������� ���Ǵ� ����� ��Ƽ� ���� : ���� ���
 *             ------
 *             1) PointCut : � �޼ҵ忡 ����
 *             2) JoinPoint : � ��ġ���� ȣ��
 *             public void display()
 *             {
 *             		******Before : driver���
 *             	    try
 *                  {
 *                  		****** setAutoCommit(false)
 *                  		ó���κ� | - Around
 *                  		****** commit() : Ʈ������ , �α�����
 *                  }catch(Exception ex)
 *                  {
 *                  		****** after-throwing : catch ����
 *                  }
 *                  finally
 *                  {
 *                  		****** after
 *                  }
 *                  
 *                  ****** after-returning
 *             }
 *             3) Advice : PointCut+JoinPoint
 *             4) Weaving : �ҽ��� �����ϴ� ����
 *         -- ���ͼ�Ʈ : �ڵ� �α��� / ����
 *         
 *         
 *       3. MVC => ��
 *       4. ORM => MyBatis
 *          *** DI , AOP , MVC ����
 *       ============================= Basic
 *       5. ���ͼ�Ʈ
 *       6. ���뿹��ó��
 *       7. ����
 *       8. ��ä��
 *       =============
 */
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MaDAO dao=(MaDAO)app.getBean("dao");
		dao.insert();
		dao.select();
		dao.update();
		dao.delete();
		System.out.println(dao.find("HELLO"));
		
	}
}

package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.*;

public class App {

	public static void main(String[] args) {
    	try {
			insertarRegistros();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Ejecutar solo para crear y llenar la BD.
	}
	
	public static void insertarRegistros() throws ParseException {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
    	SessionFactory sessionFactory;
    	Configuration configuration = (Configuration) appContext.getBean("BConfiguration");
    	configuration.configure();	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
    	
    	session.beginTransaction();
    	/*--CARGO DATOS EN TABLA TIPO USUARIO*/
    	Tipo_Usuario tipoUsuario1 = (Tipo_Usuario) appContext.getBean("BTipo_Usuario");
    	tipoUsuario1.setIdTipoUsuario(1);
    	tipoUsuario1.setDescripcion("Banco");
    	
    	Tipo_Usuario tipoUsuario2 = (Tipo_Usuario) appContext.getBean("BTipo_Usuario");
    	tipoUsuario2.setIdTipoUsuario(2);
    	tipoUsuario2.setDescripcion("Cliente");
    	
    	session.save(tipoUsuario1);
    	session.save(tipoUsuario2);
    	  	
       	//---------------------------------------------------
    	/*--CARGO DATOS TABLA GENEROS--*/
    	Genero gen1 = (Genero) appContext.getBean("BGenero");
    	gen1.setIdGenero(1);
    	gen1.setDescripcion("Femenino");
    	
    	Genero gen2 = (Genero) appContext.getBean("BGenero");
    	gen2.setIdGenero(2);
    	gen2.setDescripcion("Masculino");
    	
    	Genero gen3 = (Genero) appContext.getBean("BGenero");
    	gen3.setIdGenero(3);
    	gen3.setDescripcion("Otros");
    	
    	session.save(gen1);
    	session.save(gen2);
    	session.save(gen3);
    	//-----------------------------------------------------------
    	/*--CARGO DATOS EN TABLA TIPO CUENTA--*/
    	Tipo_Cuenta tipoCuenta1 = (Tipo_Cuenta) appContext.getBean("BTipo_Cuenta");
    	tipoCuenta1.setIdTipoCuenta(1);
    	tipoCuenta1.setMoneda("Pesos");
    	tipoCuenta1.setDescripcion("Caja de ahorro en pesos");
    	
    	Tipo_Cuenta tipoCuenta2 = (Tipo_Cuenta) appContext.getBean("BTipo_Cuenta");
    	tipoCuenta2.setIdTipoCuenta(2);
    	tipoCuenta2.setMoneda("Dólares");
    	tipoCuenta2.setDescripcion("Caja de ahorro en dolares");
    	
    	Tipo_Cuenta tipoCuenta3 = (Tipo_Cuenta) appContext.getBean("BTipo_Cuenta");
    	tipoCuenta3.setIdTipoCuenta(3);
    	tipoCuenta3.setMoneda("Pesos");
    	tipoCuenta3.setDescripcion("Cuenta corriente");
    	
    	Tipo_Cuenta tipoCuenta4 = (Tipo_Cuenta) appContext.getBean("BTipo_Cuenta");
    	tipoCuenta4.setIdTipoCuenta(4);
    	tipoCuenta4.setMoneda("Pesos");
    	tipoCuenta4.setDescripcion("Cuenta corriente especial en pesos");
    	
    	Tipo_Cuenta tipoCuenta5 = (Tipo_Cuenta) appContext.getBean("BTipo_Cuenta");
    	tipoCuenta5.setIdTipoCuenta(5);
    	tipoCuenta5.setMoneda("Dólares");
    	tipoCuenta5.setDescripcion("Cuenta corriente especial en dolares");
    	
    	session.save(tipoCuenta1);
    	session.save(tipoCuenta2);
    	session.save(tipoCuenta3);
    	session.save(tipoCuenta4);
    	session.save(tipoCuenta5);
    	
    	//---------------------------------------------------------------
    	/*--CARGO DATOS EN TABLA PROVINCIA--*/
    	Provincia prov1 = (Provincia) appContext.getBean("BProvincia");
    	prov1.setIdProvincia(1);
    	prov1.setProvNombre("Ciudad Autónoma de Buenos Aires (CABA)");
    	prov1.setCodigo("AR-C");
    	
    	Provincia prov2 = (Provincia) appContext.getBean("BProvincia");
    	prov2.setIdProvincia(2);
    	prov2.setProvNombre("Buenos Aires");
    	prov2.setCodigo("AR-B");
    	
    	Provincia prov3 = (Provincia) appContext.getBean("BProvincia");
    	prov3.setIdProvincia(3);
    	prov3.setProvNombre("Catamarca");
    	prov3.setCodigo("AR-K");
    	
    	Provincia prov4 = (Provincia) appContext.getBean("BProvincia");
    	prov4.setIdProvincia(4);
    	prov4.setProvNombre("Cordoba");
    	prov4.setCodigo("AR-x");
    	
    	Provincia prov5 = (Provincia) appContext.getBean("BProvincia");
    	prov5.setIdProvincia(5);
    	prov5.setProvNombre("Corrientes");
    	prov5.setCodigo("AR-W");
    	
    	Provincia prov6 = (Provincia) appContext.getBean("BProvincia");
    	prov6.setIdProvincia(6);
    	prov6.setProvNombre("Entre Ríos");
    	prov6.setCodigo("AR-E");
    	
    	Provincia prov7 = (Provincia) appContext.getBean("BProvincia");
    	prov7.setIdProvincia(7);
    	prov7.setProvNombre("Jujuy");
    	prov7.setCodigo("AR-Y");
    	
    	Provincia prov8 = (Provincia) appContext.getBean("BProvincia");
    	prov8.setIdProvincia(8);
    	prov8.setProvNombre("Mendoza");
    	prov8.setCodigo("AR-M");
    	
    	Provincia prov9 = (Provincia) appContext.getBean("BProvincia");
    	prov9.setIdProvincia(9);
    	prov9.setProvNombre("La Rioja");
    	prov9.setCodigo("AR-F");
    	
    	Provincia prov10 = (Provincia) appContext.getBean("BProvincia");
    	prov10.setIdProvincia(10);
    	prov10.setProvNombre("Salta");
    	prov10.setCodigo("AR-A");
    	
    	Provincia prov11 = (Provincia) appContext.getBean("BProvincia");
    	prov11.setIdProvincia(11);
    	prov11.setProvNombre("San Juan");
    	prov11.setCodigo("AR-J");
    	
    	Provincia prov12 = (Provincia) appContext.getBean("BProvincia");
    	prov12.setIdProvincia(12);
    	prov12.setProvNombre("San Luis");
    	prov12.setCodigo("AR-D");
    	
    	Provincia prov13 = (Provincia) appContext.getBean("BProvincia");
    	prov13.setIdProvincia(13);
    	prov13.setProvNombre("Santa Fe");
    	prov13.setCodigo("AR-S");
    	
    	Provincia prov14 = (Provincia) appContext.getBean("BProvincia");
    	prov14.setIdProvincia(14);
    	prov14.setProvNombre("Santiago del Estero");
    	prov14.setCodigo("AR-G");
    	
    	Provincia prov15 = (Provincia) appContext.getBean("BProvincia");
    	prov15.setIdProvincia(15);
    	prov15.setProvNombre("Tucumán");
    	prov15.setCodigo("AR-T");
    	
    	Provincia prov16 = (Provincia) appContext.getBean("BProvincia");
    	prov16.setIdProvincia(16);
    	prov16.setProvNombre("Chaco");
    	prov16.setCodigo("AR-H");
    	
    	Provincia prov17 = (Provincia) appContext.getBean("BProvincia");
    	prov17.setIdProvincia(17);
    	prov17.setProvNombre("Chubut");
    	prov17.setCodigo("AR-N");
    	
    	Provincia prov18 = (Provincia) appContext.getBean("BProvincia");
    	prov18.setIdProvincia(18);
    	prov18.setProvNombre("Formosa");
    	prov18.setCodigo("AR-P");
    	
    	Provincia prov19 = (Provincia) appContext.getBean("BProvincia");
    	prov19.setIdProvincia(19);
    	prov19.setProvNombre("Misiones");
    	prov19.setCodigo("AR-N");
    	
    	Provincia prov20 = (Provincia) appContext.getBean("BProvincia");
    	prov20.setIdProvincia(20);
    	prov20.setProvNombre("Neuquén");
    	prov20.setCodigo("AR-Q");
    	
    	Provincia prov21 = (Provincia) appContext.getBean("BProvincia");
    	prov21.setIdProvincia(21);
    	prov21.setProvNombre("La Pampa");
    	prov21.setCodigo("AR-L");
    	
    	Provincia prov22 = (Provincia) appContext.getBean("BProvincia");
    	prov22.setIdProvincia(22);
    	prov22.setProvNombre("Río Negro");
    	prov22.setCodigo("AR-R");
    	
    	Provincia prov23 = (Provincia) appContext.getBean("BProvincia");
    	prov23.setIdProvincia(23);
    	prov23.setProvNombre("Santa Cruz");
    	prov23.setCodigo("AR-Z");
    	
    	
    	Provincia prov24 = (Provincia) appContext.getBean("BProvincia");
    	prov24.setIdProvincia(24);
    	prov24.setProvNombre("Tierra del Fuego");
    	prov24.setCodigo("AR-V");
    	
    	session.save(prov1);
    	session.save(prov2);
    	session.save(prov3);
    	session.save(prov4);
    	session.save(prov5);
    	session.save(prov6);
    	session.save(prov7);
    	session.save(prov8);
    	session.save(prov9);
    	session.save(prov10);
    	session.save(prov11);
    	session.save(prov12);
    	session.save(prov13);
    	session.save(prov14);
    	session.save(prov15);
    	session.save(prov16);
    	session.save(prov17);
    	session.save(prov18);
    	session.save(prov19);
    	session.save(prov20);
    	session.save(prov21);
    	session.save(prov22);
    	session.save(prov23);
    	session.save(prov24);
    	//---------------------------------------------------------------
    	/*--CARGO DATOS TABLA LOCALIDAD*/
    	//ciudad autonoma de bsas
    	Localidad local1 = (Localidad) appContext.getBean("BLocalidad");
    	local1.setIdLocalidad(1);
    	local1.setProvLoc(prov1);
    	local1.setLocNombre("C.A.B.A");
    	local1.setCodigoPostal("0");
    	
    	//BS AS
    	Localidad local2 = (Localidad) appContext.getBean("BLocalidad");
    	local2.setIdLocalidad(2);
    	local2.setProvLoc(prov2);
    	local2.setLocNombre("AVELLANEDA");
    	local2.setCodigoPostal("1870");
    	
    	Localidad local3 = (Localidad) appContext.getBean("BLocalidad");
    	local3.setIdLocalidad(3);
    	local3.setProvLoc(prov2);
    	local3.setLocNombre("DOCK SUD");
    	local3.setCodigoPostal("1871");
    	
    	Localidad local11 = (Localidad) appContext.getBean("BLocalidad");
    	local11.setIdLocalidad(11);
    	local11.setProvLoc(prov2);
    	local11.setLocNombre("PILAR");
    	local11.setCodigoPostal("3505");
    	
    	Localidad local7 = (Localidad) appContext.getBean("BLocalidad");
    	local7.setIdLocalidad(7);
    	local7.setProvLoc(prov2);
    	local7.setLocNombre("GENERAL ALVEAR");
    	local7.setCodigoPostal("7263");
    	
    	Localidad local8 = (Localidad) appContext.getBean("BLocalidad");
    	local8.setIdLocalidad(8);
    	local8.setProvLoc(prov2);
    	local8.setLocNombre("VILLA CERRITO");
    	local8.setCodigoPostal("8000");
    	
    	Localidad local9 = (Localidad) appContext.getBean("BLocalidad");
    	local9.setIdLocalidad(9);
    	local9.setProvLoc(prov2);
    	local9.setLocNombre("ALSINA");
    	local9.setCodigoPostal("2938");
    	
    	Localidad local10 = (Localidad) appContext.getBean("BLocalidad");
    	local10.setIdLocalidad(10);
    	local10.setProvLoc(prov2);
    	local10.setLocNombre("MONTE CRESPO");
    	local10.setCodigoPostal("7020");
    	
    	//Mendoza
    	Localidad local4 = (Localidad) appContext.getBean("BLocalidad");
    	local4.setIdLocalidad(4);
    	local4.setProvLoc(prov8);
    	local4.setLocNombre("SAN JOSE");
    	local4.setCodigoPostal("5535");
    	
    	Localidad local12 = (Localidad) appContext.getBean("BLocalidad");
    	local12.setIdLocalidad(12);
    	local12.setProvLoc(prov8);
    	local12.setLocNombre("AGUA NUEVA");
    	local12.setCodigoPostal("5600");
    	
    	Localidad local13 = (Localidad) appContext.getBean("BLocalidad");
    	local13.setIdLocalidad(13);
    	local13.setProvLoc(prov8);
    	local13.setLocNombre("AGUA DE LA MULA");
    	local13.setCodigoPostal("5600");
    	
    	//Catamarca
    	Localidad local14 = (Localidad) appContext.getBean("BLocalidad");
    	local14.setIdLocalidad(14);
    	local14.setProvLoc(prov3);
    	local14.setLocNombre("ANTINACO");
    	local14.setCodigoPostal("5341");
    	
    	Localidad local15 = (Localidad) appContext.getBean("BLocalidad");
    	local15.setIdLocalidad(15);
    	local15.setProvLoc(prov3);
    	local15.setLocNombre("MINAS CAPILLITAS");
    	local15.setCodigoPostal("4740");
    	
    	Localidad local16 = (Localidad) appContext.getBean("BLocalidad");
    	local16.setIdLocalidad(16);
    	local16.setProvLoc(prov3);
    	local16.setLocNombre("LAMPASITO");
    	local16.setCodigoPostal("4139");
    	
    	//Cordoba
    	
    	Localidad local5 = (Localidad) appContext.getBean("BLocalidad");
    	local5.setIdLocalidad(5);
    	local5.setProvLoc(prov4);
    	local5.setLocNombre("LOS PATOS");
    	local5.setCodigoPostal("7603");
    	
    	Localidad local17 = (Localidad) appContext.getBean("BLocalidad");
    	local17.setIdLocalidad(17);
    	local17.setProvLoc(prov4);
    	local17.setLocNombre("LA CONCEPCION");
    	local17.setCodigoPostal("5281");
    	
    	Localidad local18 = (Localidad) appContext.getBean("BLocalidad");
    	local18.setIdLocalidad(18);
    	local18.setProvLoc(prov4);
    	local18.setLocNombre("VILLA CIUDAD PQUE LOS REARTES");
    	local18.setCodigoPostal("5189");
    	
    	//Santa Fe
    	Localidad local6 = (Localidad) appContext.getBean("BLocalidad");
    	local6.setIdLocalidad(6);
    	local6.setProvLoc(prov13);
    	local6.setLocNombre("MIRAMAR");
    	local6.setCodigoPostal("7607");
    	
    	Localidad local20 = (Localidad) appContext.getBean("BLocalidad");
    	local20.setIdLocalidad(20);
    	local20.setProvLoc(prov13);
    	local20.setLocNombre("MIGUEL TORRES");
    	local20.setCodigoPostal("2631");
    	
    	Localidad local21 = (Localidad) appContext.getBean("BLocalidad");
    	local21.setIdLocalidad(21);
    	local21.setProvLoc(prov13);
    	local21.setLocNombre("RASTREADOR FOURNIER");
    	local21.setCodigoPostal("2605");
    	
    	//Chaco
    	Localidad local22 = (Localidad) appContext.getBean("BLocalidad");
    	local22.setIdLocalidad(22);
    	local22.setProvLoc(prov16);
    	local22.setLocNombre("COLONIA BENITEZ");
    	local22.setCodigoPostal("3505");
    	
    	Localidad local23 = (Localidad) appContext.getBean("BLocalidad");
    	local23.setIdLocalidad(23);
    	local23.setProvLoc(prov16);
    	local23.setLocNombre("COLONIA EL PILAR");
    	local23.setCodigoPostal("3505");
    	
    	Localidad local24 = (Localidad) appContext.getBean("BLocalidad");
    	local24.setIdLocalidad(24);
    	local24.setProvLoc(prov16);
    	local24.setLocNombre("PUERTO ANTEQUERA");
    	local24.setCodigoPostal("3505");
    	
    	//Chubut
    	Localidad local25 = (Localidad) appContext.getBean("BLocalidad");
    	local25.setIdLocalidad(25);
    	local25.setProvLoc(prov17);
    	local25.setLocNombre("LAGUNA DE VACAS");
    	local25.setCodigoPostal("9121");
    	
    	Localidad local26 = (Localidad) appContext.getBean("BLocalidad");
    	local26.setIdLocalidad(26);
    	local26.setProvLoc(prov17);
    	local26.setLocNombre("FRONTERA DE RIO PICO");
    	local26.setCodigoPostal("9225");
    	
    	Localidad local27 = (Localidad) appContext.getBean("BLocalidad");
    	local27.setIdLocalidad(27);
    	local27.setProvLoc(prov17);
    	local27.setLocNombre("LAGO PAZ");
    	local27.setCodigoPostal("9225");
    	
    	//Corrientes
    	Localidad local28 = (Localidad) appContext.getBean("BLocalidad");
    	local28.setIdLocalidad(28);
    	local28.setProvLoc(prov5);
    	local28.setLocNombre("VACA PASO");
    	local28.setCodigoPostal("3461");

    	Localidad local29 = (Localidad) appContext.getBean("BLocalidad");
    	local29.setIdLocalidad(29);
    	local29.setProvLoc(prov5);
    	local29.setLocNombre("CUARTA SECCION LOMAS");
    	local29.setCodigoPostal("3461");
    	
    	Localidad local30 = (Localidad) appContext.getBean("BLocalidad");
    	local30.setIdLocalidad(30);
    	local30.setProvLoc(prov5);
    	local30.setLocNombre("RINCON QUIROZ");
    	local30.setCodigoPostal("3461");
    	
    	//Entre Ríos
    	Localidad local31 = (Localidad) appContext.getBean("BLocalidad");
    	local31.setIdLocalidad(31);
    	local31.setProvLoc(prov6);
    	local31.setLocNombre("ZONA DELTA GUALEGUAYCHU");
    	local31.setCodigoPostal("2820");
    	
    	Localidad local32 = (Localidad) appContext.getBean("BLocalidad");
    	local32.setIdLocalidad(32);
    	local32.setProvLoc(prov6);
    	local32.setLocNombre("COLONIA BERTOZZI");
    	local32.setCodigoPostal("3192");
    	
    	Localidad local33 = (Localidad) appContext.getBean("BLocalidad");
    	local33.setIdLocalidad(33);
    	local33.setProvLoc(prov6);
    	local33.setLocNombre("COLONIA LA MARTA");
    	local33.setCodigoPostal("3185");
    	
    	//Formosa
    	Localidad local34 = (Localidad) appContext.getBean("BLocalidad");
    	local34.setIdLocalidad(34);
    	local34.setProvLoc(prov18);
    	local34.setLocNombre("ISLA GRAL BELGRANO");
    	local34.setCodigoPostal("3610");
    	
    	Localidad local35 = (Localidad) appContext.getBean("BLocalidad");
    	local35.setIdLocalidad(35);
    	local35.setProvLoc(prov18);
    	local35.setLocNombre("PUNTA DE AGUA");
    	local35.setCodigoPostal("3630");
    	
    	Localidad local36 = (Localidad) appContext.getBean("BLocalidad");
    	local36.setIdLocalidad(36);
    	local36.setProvLoc(prov18);
    	local36.setLocNombre("PESCADO NEGRO");
    	local36.setCodigoPostal("3636");
    	
    	//Jujuy
    	Localidad local37 = (Localidad) appContext.getBean("BLocalidad");
    	local37.setIdLocalidad(37);
    	local37.setProvLoc(prov7);
    	local37.setLocNombre("EL CHAGUARAL");
    	local37.setCodigoPostal("4500");
    	
    	Localidad local38 = (Localidad) appContext.getBean("BLocalidad");
    	local38.setIdLocalidad(38);
    	local38.setProvLoc(prov7);
    	local38.setLocNombre("CERRO AGUA CALIENTE");
    	local38.setCodigoPostal("4641");
    	
    	Localidad local39 = (Localidad) appContext.getBean("BLocalidad");
    	local39.setIdLocalidad(39);
    	local39.setProvLoc(prov7);
    	local39.setLocNombre("AGUAS CALIENTES");
    	local39.setCodigoPostal("4518");
    	
    	//La Pampa
    	Localidad local40 = (Localidad) appContext.getBean("BLocalidad");
    	local40.setIdLocalidad(40);
    	local40.setProvLoc(prov21);
    	local40.setLocNombre("ATREUCO");
    	local40.setCodigoPostal("6305");
    	
    	Localidad local41 = (Localidad) appContext.getBean("BLocalidad");
    	local41.setIdLocalidad(41);
    	local41.setProvLoc(prov21);
    	local41.setLocNombre("BELLA VISTA");
    	local41.setCodigoPostal("6305");
    	
    	Localidad local42 = (Localidad) appContext.getBean("BLocalidad");
    	local42.setIdLocalidad(42);
    	local42.setProvLoc(prov21);
    	local42.setLocNombre("CEREALES");
    	local42.setCodigoPostal("6301");
    	
    	//La Rioja
    	Localidad local43 = (Localidad) appContext.getBean("BLocalidad");
    	local43.setIdLocalidad(43);
    	local43.setProvLoc(prov9);
    	local43.setLocNombre("AIMOGASTA");
    	local43.setCodigoPostal("5310");
    	
    	Localidad local44 = (Localidad) appContext.getBean("BLocalidad");
    	local44.setIdLocalidad(44);
    	local44.setProvLoc(prov9);
    	local44.setLocNombre("ARAUCO");
    	local44.setCodigoPostal("5311");
    	
    	Localidad local45 = (Localidad) appContext.getBean("BLocalidad");
    	local45.setIdLocalidad(45);
    	local45.setProvLoc(prov9);
    	local45.setLocNombre("ESTACION MAZAN");
    	local45.setCodigoPostal("5313");
    	
    	//Misiones 
    	Localidad local46 = (Localidad) appContext.getBean("BLocalidad");
    	local46.setIdLocalidad(46);
    	local46.setProvLoc(prov19);
    	local46.setLocNombre("9 DE JULIO");
    	local46.setCodigoPostal("3363");
    	
    	Localidad local47 = (Localidad) appContext.getBean("BLocalidad");
    	local47.setIdLocalidad(47);
    	local47.setProvLoc(prov19);
    	local47.setLocNombre("BARRA BONITA");
    	local47.setCodigoPostal("3357");
    	
    	Localidad local48 = (Localidad) appContext.getBean("BLocalidad");
    	local48.setIdLocalidad(48);
    	local48.setProvLoc(prov19);
    	local48.setLocNombre("CAMPOS SALLES");
    	local48.setCodigoPostal("3363");
    	
    	//Neuquén
    	Localidad local49 = (Localidad) appContext.getBean("BLocalidad");
    	local49.setIdLocalidad(49);
    	local49.setProvLoc(prov20);
    	local49.setLocNombre("BUTALON");
    	local49.setCodigoPostal("8353");
    	
    	Localidad local50 = (Localidad) appContext.getBean("BLocalidad");
    	local50.setIdLocalidad(50);
    	local50.setProvLoc(prov20);
    	local50.setLocNombre("FORTIN GUA");
    	local50.setCodigoPostal("8353");
    	
    	Localidad local51 = (Localidad) appContext.getBean("BLocalidad");
    	local51.setIdLocalidad(51);
    	local51.setProvLoc(prov20);
    	local51.setLocNombre("HUARACO");
    	local51.setCodigoPostal("8353");
    	
    	//Río Negro
    	Localidad local52 = (Localidad) appContext.getBean("BLocalidad");
    	local52.setIdLocalidad(52);
    	local52.setProvLoc(prov22);
    	local52.setLocNombre("LAGUNA BLANCA");
    	local52.setCodigoPostal("8417");
    	
    	Localidad local53 = (Localidad) appContext.getBean("BLocalidad");
    	local53.setIdLocalidad(53);
    	local53.setProvLoc(prov22);
    	local53.setLocNombre("CUBANEA");
    	local53.setCodigoPostal("8501");
    	
    	Localidad local54 = (Localidad) appContext.getBean("BLocalidad");
    	local54.setIdLocalidad(54);
    	local54.setProvLoc(prov22);
    	local54.setLocNombre("COLAN CONHUE");
    	local54.setCodigoPostal("8418");
    	
    	//Salta
    	Localidad local55 = (Localidad) appContext.getBean("BLocalidad");
    	local55.setIdLocalidad(55);
    	local55.setProvLoc(prov10);
    	local55.setLocNombre("AGUA SUCIA");
    	local55.setCodigoPostal("4449");
    	
    	Localidad local56 = (Localidad) appContext.getBean("BLocalidad");
    	local56.setIdLocalidad(56);
    	local56.setProvLoc(prov10);
    	local56.setLocNombre("ALGARROBAL");
    	local56.setCodigoPostal("4446");
    	
    	Localidad local57 = (Localidad) appContext.getBean("BLocalidad");
    	local57.setIdLocalidad(57);
    	local57.setProvLoc(prov10);
    	local57.setLocNombre("ALTO ALEGRE");
    	local57.setCodigoPostal("4449");
    	
    	//San Juan
    	Localidad local58 = (Localidad) appContext.getBean("BLocalidad");
    	local58.setIdLocalidad(58);
    	local58.setProvLoc(prov11);
    	local58.setLocNombre("ALGARROBO VERDE");
    	local58.setCodigoPostal("5443");
    	
    	Localidad local59 = (Localidad) appContext.getBean("BLocalidad");
    	local59.setIdLocalidad(59);
    	local59.setProvLoc(prov11);
    	local59.setLocNombre("CUATRO ESQUINAS");
    	local59.setCodigoPostal("5443");
    	
    	Localidad local60 = (Localidad) appContext.getBean("BLocalidad");
    	local60.setIdLocalidad(60);
    	local60.setProvLoc(prov11);
    	local60.setLocNombre("CUYO");
    	local60.setCodigoPostal("5443");
    	
    	//San Luis
    	Localidad local61 = (Localidad) appContext.getBean("BLocalidad");
    	local61.setIdLocalidad(61);
    	local61.setProvLoc(prov12);
    	local61.setLocNombre("EL ESPINILLO");
    	local61.setCodigoPostal("6279");
    	
    	Localidad local62 = (Localidad) appContext.getBean("BLocalidad");
    	local62.setIdLocalidad(62);
    	local62.setProvLoc(prov12);
    	local62.setLocNombre("AGUADITAS");
    	local62.setCodigoPostal("5707");
    	
    	Localidad local63 = (Localidad) appContext.getBean("BLocalidad");
    	local63.setIdLocalidad(63);
    	local63.setProvLoc(prov12);
    	local63.setLocNombre("BALDE DE ESCUDERO");
    	local63.setCodigoPostal("5715");
    	
    	//Santa Cruz
    	Localidad local64 = (Localidad) appContext.getBean("BLocalidad");
    	local64.setIdLocalidad(64);
    	local64.setProvLoc(prov23);
    	local64.setLocNombre("EL GUADAL");
    	local64.setCodigoPostal("9300");
    	
    	Localidad local65 = (Localidad) appContext.getBean("BLocalidad");
    	local65.setIdLocalidad(65);
    	local65.setProvLoc(prov23);
    	local65.setLocNombre("AGUADA A PIQUE");
    	local65.setCodigoPostal("9051");
    	
    	Localidad local66 = (Localidad) appContext.getBean("BLocalidad");
    	local66.setIdLocalidad(66);
    	local66.setProvLoc(prov23);
    	local66.setLocNombre("AGUADA LA OVEJA");
    	local66.setCodigoPostal("9051");
    	
    	//Santiago del Estero
    	Localidad local67 = (Localidad) appContext.getBean("BLocalidad");
    	local67.setIdLocalidad(67);
    	local67.setProvLoc(prov14);
    	local67.setLocNombre("CERRILLO");
    	local67.setCodigoPostal("4336");
    	
    	Localidad local68 = (Localidad) appContext.getBean("BLocalidad");
    	local68.setIdLocalidad(68);
    	local68.setProvLoc(prov14);
    	local68.setLocNombre("EL DIAMANTE");
    	local68.setCodigoPostal("4336");
    	
    	Localidad local69 = (Localidad) appContext.getBean("BLocalidad");
    	local69.setIdLocalidad(69);
    	local69.setProvLoc(prov14);
    	local69.setLocNombre("LOS HERRERAS");
    	local69.setCodigoPostal("4336");
    	
    	//Tierra del Fuego
    	Localidad local70 = (Localidad) appContext.getBean("BLocalidad");
    	local70.setIdLocalidad(70);
    	local70.setProvLoc(prov24);
    	local70.setLocNombre("BAHIA LAPATAIA");
    	local70.setCodigoPostal("9410");
    	
    	Localidad local71 = (Localidad) appContext.getBean("BLocalidad");
    	local71.setIdLocalidad(71);
    	local71.setProvLoc(prov24);
    	local71.setLocNombre("ESTANCIA HARBERTON");
    	local71.setCodigoPostal("9410");
    	
    	Localidad local72 = (Localidad) appContext.getBean("BLocalidad");
    	local72.setIdLocalidad(72);
    	local72.setProvLoc(prov24);
    	local72.setLocNombre("HOSTERIA KAIKEN");
    	local72.setCodigoPostal("9410");
    	
    	//Tucumán
    	Localidad local73 = (Localidad) appContext.getBean("BLocalidad");
    	local73.setIdLocalidad(73);
    	local73.setProvLoc(prov15);
    	local73.setLocNombre("HOSTERIA KAIKEN");
    	local73.setCodigoPostal("9410");
    	
    	Localidad local74 = (Localidad) appContext.getBean("BLocalidad");
    	local74.setIdLocalidad(74);
    	local74.setProvLoc(prov15);
    	local74.setLocNombre("HOSTERIA KAIKEN");
    	local74.setCodigoPostal("9410");
    	
    	Localidad local75 = (Localidad) appContext.getBean("BLocalidad");
    	local75.setIdLocalidad(75);
    	local75.setProvLoc(prov15);
    	local75.setLocNombre("HOSTERIA KAIKEN");
    	local75.setCodigoPostal("9410");
    	
    	
    	session.save(local1);
    	session.save(local2);
    	session.save(local3);
    	session.save(local4);
    	session.save(local5);
    	session.save(local6);
    	session.save(local7);
    	session.save(local8);
    	session.save(local9);
    	session.save(local10);
    	session.save(local11);
    	session.save(local12);
    	session.save(local13);
    	session.save(local14);
    	session.save(local15);
    	session.save(local16);
    	session.save(local17);
    	session.save(local18);
    	session.save(local20);
    	session.save(local21);
    	session.save(local22);
    	session.save(local23);
    	session.save(local24);
    	session.save(local25);
    	session.save(local26);
    	session.save(local27);
    	session.save(local28);
    	session.save(local29);
    	session.save(local30);
    	session.save(local31);
    	session.save(local32);
    	session.save(local33);
    	session.save(local34);
    	session.save(local35);
    	session.save(local36);
    	session.save(local37);
    	session.save(local38);
    	session.save(local39);
    	session.save(local40);
    	session.save(local41);
    	session.save(local42);
    	session.save(local43);
    	session.save(local44);
    	session.save(local45);
    	session.save(local46);
    	session.save(local47);
    	session.save(local48);
    	session.save(local49);
    	session.save(local50);
    	session.save(local51);
    	session.save(local52);
    	session.save(local53);
    	session.save(local54);
    	session.save(local55);
    	session.save(local56);
    	session.save(local57);
    	session.save(local58);
    	session.save(local59);
    	session.save(local60);
    	session.save(local61);
    	session.save(local62);
    	session.save(local63);
    	session.save(local64);
    	session.save(local65);
    	session.save(local66);
    	session.save(local67);
    	session.save(local68);
    	session.save(local69);
    	session.save(local70);
    	session.save(local71);
    	session.save(local72);
    	session.save(local73);
    	session.save(local74);
    	session.save(local75);
    	
    	//---------------------------------------------------------------
    	/*--CARGO DATOS EN TABLA TIPO MOVIMIENTO--*/
    	Tipo_Movimiento tipoMovimient1 = (Tipo_Movimiento) appContext.getBean("BTipo_Movimiento");
    	tipoMovimient1.setIdTipoMovimiento(1);
    	tipoMovimient1.setDescripcion("Alta de cuenta");
    	
    	Tipo_Movimiento tipoMovimient2 = (Tipo_Movimiento) appContext.getBean("BTipo_Movimiento");
    	tipoMovimient2.setIdTipoMovimiento(2);
    	tipoMovimient2.setDescripcion("Alta de un prestamo");
    	
    	Tipo_Movimiento tipoMovimient3 = (Tipo_Movimiento) appContext.getBean("BTipo_Movimiento");
    	tipoMovimient3.setIdTipoMovimiento(3);
    	tipoMovimient3.setDescripcion("Pago de un prestamo");
    	
    	Tipo_Movimiento tipoMovimient4 = (Tipo_Movimiento) appContext.getBean("BTipo_Movimiento");
    	tipoMovimient4.setIdTipoMovimiento(4);
    	tipoMovimient4.setDescripcion("Transferencia");
    	
    	session.save(tipoMovimient1);
    	session.save(tipoMovimient2);
    	session.save(tipoMovimient3);
    	session.save(tipoMovimient4);
    	//---------------------------------------------------------------
    	
    	/*--CARGO DATOS EN TABLA USUARIO--*/
    	Usuario usuario1 = (Usuario) appContext.getBean("BUsuario");
    	usuario1.setDni("30000001");
    	usuario1.setTipoUsu(tipoUsuario1);
    	usuario1.setGen(gen1);
    	usuario1.setLoc(local5);
    	usuario1.setNombre("Daniela");
    	usuario1.setApellido("Alessio");
    	usuario1.setNacionalidad("Argentino");
    	usuario1.setFechaNac(new Date());
    	usuario1.setEstado(true);
    	usuario1.setDireccion("Mosconi 556");
    	usuario1.setTel("1126987435");
    	usuario1.setEmail("dalessio@gmail.com");
    	
    	Usuario usuario2 = (Usuario) appContext.getBean("BUsuario");
    	usuario2.setDni("30000002");
    	usuario2.setTipoUsu(tipoUsuario2);
    	usuario2.setGen(gen2);
    	usuario2.setLoc(local3);
    	usuario2.setNombre("Juan");
    	usuario2.setApellido("Cassano");
    	usuario2.setNacionalidad("Argentino");
    	usuario2.setFechaNac(new Date());
    	usuario2.setEstado(true);
    	usuario2.setDireccion("Riobamba 126");
    	usuario2.setTel("1126987436");
    	usuario2.setEmail("jcasano@gmail.com");
    	
    	Usuario usuario3 = (Usuario) appContext.getBean("BUsuario");
    	usuario3.setDni("30000003");
    	usuario3.setTipoUsu(tipoUsuario2);
    	usuario3.setGen(gen2);
    	usuario3.setLoc(local1);
    	usuario3.setNombre("Leandro");
    	usuario3.setApellido("Lescano");
    	usuario3.setNacionalidad("Argentino");
    	usuario3.setFechaNac(new Date());
    	usuario3.setEstado(true);
    	usuario3.setDireccion("Alsina 236");
    	usuario3.setTel("1126987437");
    	usuario3.setEmail("llescano@gmail.com");
    	
    	Usuario usuario4 = (Usuario) appContext.getBean("BUsuario");
    	usuario4.setDni("30000004");
    	usuario4.setTipoUsu(tipoUsuario2);
    	usuario4.setGen(gen2);
    	usuario4.setLoc(local2);
    	usuario4.setNombre("Sebastian");
    	usuario4.setApellido("Font");
    	usuario4.setNacionalidad("Argentino");
    	usuario4.setFechaNac(new Date());
    	usuario4.setEstado(true);
    	usuario4.setDireccion("General Paz 546");
    	usuario4.setTel("1126987438");
    	usuario4.setEmail("sfont@gmail.com");
    	
    	Usuario usuario5 = (Usuario) appContext.getBean("BUsuario");
    	usuario5.setDni("30000005");
    	usuario5.setTipoUsu(tipoUsuario2);
    	usuario5.setGen(gen2);
    	usuario5.setLoc(local4);
    	usuario5.setNombre("Matias");
    	usuario5.setApellido("Medela");
    	usuario5.setNacionalidad("Argentino");
    	usuario5.setFechaNac(new Date());
    	usuario5.setEstado(true);
    	usuario5.setDireccion("Mosconi 546");
    	usuario5.setTel("1126987439");
    	usuario5.setEmail("mmedela@gmail.com");
    	
    	Usuario usuario6 = (Usuario) appContext.getBean("BUsuario");
    	usuario6.setDni("30000006");
    	usuario6.setTipoUsu(tipoUsuario2);
    	usuario6.setGen(gen2);
    	usuario6.setLoc(local3);
    	usuario6.setNombre("Juan");
    	usuario6.setApellido("de Lage");
    	usuario6.setNacionalidad("Argentino");
    	usuario6.setFechaNac(new Date());
    	usuario6.setEstado(true);
    	usuario6.setDireccion("Haedo 652");
    	usuario6.setTel("1126987411");
    	usuario6.setEmail("jjlage@gmail.com");
    	
    	Usuario usuario7 = (Usuario) appContext.getBean("BUsuario");
    	usuario7.setDni("30000007");
    	usuario7.setTipoUsu(tipoUsuario2);
    	usuario7.setGen(gen2);
    	usuario7.setLoc(local3);
    	usuario7.setNombre("Horacio");
    	usuario7.setApellido("Suarez");
    	usuario7.setNacionalidad("Argentino");
    	usuario7.setNacionalidad("Argentino");
    	usuario7.setFechaNac(new Date());
    	usuario7.setEstado(true);
    	usuario7.setDireccion("Av. Centenario 1256");
    	usuario7.setTel("1126987422");
    	usuario7.setEmail("hsuarez@gmail.com");
    	
    	Usuario usuario8 = (Usuario) appContext.getBean("BUsuario");
    	usuario8.setDni("30000008");
    	usuario8.setTipoUsu(tipoUsuario2);
    	usuario8.setGen(gen1);
    	usuario8.setLoc(local3);
    	usuario8.setNombre("Olga");
    	usuario8.setApellido("Capotosti");
    	usuario8.setNacionalidad("Argentino");
    	usuario8.setFechaNac(new Date());
    	usuario8.setEstado(true);
    	usuario8.setDireccion("Haedo 568");
    	usuario8.setTel("1126987433");
    	usuario8.setEmail("ocapotosti@gmail.com");
    	
    	Usuario usuario9 = (Usuario) appContext.getBean("BUsuario");
    	usuario9.setDni("30000009");
    	usuario9.setTipoUsu(tipoUsuario2);
    	usuario9.setGen(gen1);
    	usuario9.setLoc(local4);
    	usuario9.setNombre("Marisa");
    	usuario9.setApellido("Vasquez");
    	usuario9.setNacionalidad("Argentino");
    	usuario9.setFechaNac(new Date());
    	usuario9.setEstado(true);
    	usuario9.setDireccion("Alsina 326");
    	usuario9.setTel("1126987444");
    	usuario9.setEmail("mvasquez@gmail.com");
    	
    	Usuario usuario10 = (Usuario) appContext.getBean("BUsuario");
    	usuario10.setDni("30000010");
    	usuario10.setTipoUsu(tipoUsuario2);
    	usuario10.setGen(gen2);
    	usuario10.setLoc(local4);
    	usuario10.setNombre("Mariano");
    	usuario10.setApellido("Vivas");
    	usuario10.setNacionalidad("Argentino");
    	usuario10.setFechaNac(new Date());
    	usuario10.setEstado(true);
    	usuario10.setDireccion("Julian Navarro 135");
    	usuario10.setTel("1126987427");
    	usuario10.setEmail("mvivas@gmail.com");
    	
    	session.save(usuario1);
    	session.save(usuario2);
    	session.save(usuario3);
    	session.save(usuario4);
    	session.save(usuario5);
    	session.save(usuario6);
    	session.save(usuario7);
    	session.save(usuario8);
    	session.save(usuario9);
    	session.save(usuario10);
    	
    	//---------------------------------------------------------------
    	/*--CARGO DATOS EN TABLA LOGUEO*/
    	Logueo log1 = (Logueo) appContext.getBean("BLogueo");
    	log1.setNUsuario(usuario1.getEmail());
    	log1.setContrasenia(usuario1.getDni());
    	log1.setUsuario(usuario1);
    	
    	Logueo log2 = (Logueo) appContext.getBean("BLogueo");
    	log2.setNUsuario(usuario2.getEmail());
    	log2.setContrasenia(usuario2.getDni());
    	log2.setUsuario(usuario2);
    	
    	Logueo log3 = (Logueo) appContext.getBean("BLogueo");
    	log3.setNUsuario(usuario3.getEmail());
    	log3.setContrasenia(usuario3.getDni());
    	log3.setUsuario(usuario3);
    	
    	Logueo log4 = (Logueo) appContext.getBean("BLogueo");
    	log4.setNUsuario(usuario4.getEmail());
    	log4.setContrasenia(usuario4.getDni());
    	log4.setUsuario(usuario4);
    	
    	Logueo log5 = (Logueo) appContext.getBean("BLogueo");
    	log5.setNUsuario(usuario5.getEmail());
    	log5.setContrasenia(usuario5.getDni());
    	log5.setUsuario(usuario5);
    	
    	Logueo log6 = (Logueo) appContext.getBean("BLogueo");
    	log6.setNUsuario(usuario6.getEmail());
    	log6.setContrasenia(usuario6.getDni());
    	log6.setUsuario(usuario6);
    	
    	Logueo log7 = (Logueo) appContext.getBean("BLogueo");
    	log7.setNUsuario(usuario7.getEmail());
    	log7.setContrasenia(usuario7.getDni());
    	log7.setUsuario(usuario7);
    	
    	Logueo log8 = (Logueo) appContext.getBean("BLogueo");
    	log8.setNUsuario(usuario8.getEmail());
    	log8.setContrasenia(usuario8.getDni());
    	log8.setUsuario(usuario8);
    	
    	Logueo log9 = (Logueo) appContext.getBean("BLogueo");
    	log9.setNUsuario(usuario9.getEmail());
    	log9.setContrasenia(usuario9.getDni());
    	log9.setUsuario(usuario9);
    	
    	Logueo log10 = (Logueo) appContext.getBean("BLogueo");
    	log10.setNUsuario(usuario10.getEmail());
    	log10.setContrasenia(usuario10.getDni());
    	log10.setUsuario(usuario10);
    	
    	
    	session.save(log1);
    	session.save(log2);
    	session.save(log3);
    	session.save(log4);
    	session.save(log5);
    	session.save(log6);
    	session.save(log7);
    	session.save(log8);
    	session.save(log9);
    	session.save(log10);
    	//----------------------------------------------------------------
    	/*--CARGO DATOS EN TABLA CUENTA*/
    	
    	Cuenta cuenta1 = (Cuenta) appContext.getBean("BCuenta");
    	cuenta1.setIdCuenta(1);
    	cuenta1.setTipoCuenta(tipoCuenta2);
    	cuenta1.setfechaCreacion(new Date());
    	cuenta1.setCbu(1);
    	cuenta1.setAlias("GeneralPacheco2020");
    	cuenta1.setUsuario(usuario4);
    	cuenta1.setSaldo(10000);
    	cuenta1.setEstado(true);
    	
    	Cuenta cuenta2 = (Cuenta) appContext.getBean("BCuenta");
    	cuenta2.setIdCuenta(2);
    	cuenta2.setTipoCuenta(tipoCuenta3);
    	cuenta2.setfechaCreacion(new Date());
    	cuenta2.setCbu(2);
    	cuenta2.setAlias("GeneralPacheco202");
    	cuenta2.setUsuario(usuario4);
    	cuenta2.setSaldo(10000);
    	cuenta2.setEstado(true);
    	
    	Cuenta cuenta3 = (Cuenta) appContext.getBean("BCuenta");
    	cuenta3.setIdCuenta(3);
    	cuenta3.setTipoCuenta(tipoCuenta2);
    	cuenta3.setfechaCreacion(new Date());
    	cuenta3.setCbu(3);
    	cuenta3.setAlias("WinterGarden2012");
    	cuenta3.setUsuario(usuario5);
    	cuenta3.setSaldo(10000);
    	cuenta3.setEstado(true);
    	
    	Cuenta cuenta4 = (Cuenta) appContext.getBean("BCuenta");
    	cuenta4.setIdCuenta(4);
    	cuenta4.setTipoCuenta(tipoCuenta3);
    	cuenta4.setfechaCreacion(new Date());
    	cuenta4.setCbu(4);
    	cuenta4.setAlias("WinterGarden2013");
    	cuenta4.setUsuario(usuario5);
    	cuenta4.setSaldo(10000);
    	cuenta4.setEstado(true);
    	
    	Cuenta cuenta5 = (Cuenta) appContext.getBean("BCuenta");
    	cuenta5.setIdCuenta(5);
    	cuenta5.setTipoCuenta(tipoCuenta2);
    	cuenta5.setfechaCreacion(new Date());
    	cuenta5.setCbu(5);
    	cuenta5.setAlias("LaRalde3256");
    	cuenta5.setUsuario(usuario6);
    	cuenta5.setSaldo(10000);
    	cuenta5.setEstado(true);
    	
    	Cuenta cuenta6 = (Cuenta) appContext.getBean("BCuenta");
    	cuenta6.setIdCuenta(6);
    	cuenta6.setTipoCuenta(tipoCuenta3);
    	cuenta6.setfechaCreacion(new Date());
    	cuenta6.setCbu(6);
    	cuenta6.setAlias("LaRalde3245");
    	cuenta6.setUsuario(usuario6);
    	cuenta6.setSaldo(10000);
    	cuenta6.setEstado(true);
    	
    	Cuenta cuenta7 = (Cuenta) appContext.getBean("BCuenta");
    	cuenta7.setIdCuenta(7);
    	cuenta7.setTipoCuenta(tipoCuenta2);
    	cuenta7.setfechaCreacion(new Date());
    	cuenta7.setCbu(7);
    	cuenta7.setAlias("River2014");;
    	cuenta7.setUsuario(usuario7);
    	cuenta7.setSaldo(10000);
    	cuenta7.setEstado(true);
    	
    	Cuenta cuenta8 = (Cuenta) appContext.getBean("BCuenta");
    	cuenta8.setIdCuenta(8);
    	cuenta8.setTipoCuenta(tipoCuenta3);
    	cuenta8.setfechaCreacion(new Date());
    	cuenta8.setCbu(8);
    	cuenta8.setAlias("River2015");
    	cuenta8.setUsuario(usuario7);
    	cuenta8.setSaldo(10000);
    	cuenta8.setEstado(true);
    	
    	Cuenta cuenta9 = (Cuenta) appContext.getBean("BCuenta");
    	cuenta9.setIdCuenta(9);
    	cuenta9.setTipoCuenta(tipoCuenta2);
    	cuenta9.setfechaCreacion(new Date());
    	cuenta9.setCbu(9);
    	cuenta9.setUsuario(usuario8);
    	cuenta9.setAlias("Boca2007");
    	cuenta9.setSaldo(10000);
    	cuenta9.setEstado(true);
    	
    	Cuenta cuenta10 = (Cuenta) appContext.getBean("BCuenta");
    	cuenta10.setIdCuenta(10);
    	cuenta10.setTipoCuenta(tipoCuenta3);
    	cuenta10.setfechaCreacion(new Date());
    	cuenta10.setCbu(10);
    	cuenta10.setAlias("Boca2006");
    	cuenta10.setUsuario(usuario8);
    	cuenta10.setSaldo(10000);
    	cuenta10.setEstado(true);
    	
    	session.save(cuenta1);
    	session.save(cuenta2);
    	session.save(cuenta3);
    	session.save(cuenta4);
    	session.save(cuenta5);
    	session.save(cuenta6);
    	session.save(cuenta7);
    	session.save(cuenta8);
    	session.save(cuenta9);
    	session.save(cuenta10);
    	//----------------------------------------------------------------
    	/*--CARGO DATOS EN LA TABLA MOVIMIENTOS--*/
    	Movimiento movimiento1 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento1.setIdMovimiento(1);
    	movimiento1.setTipoMovimiento(tipoMovimient1);
    	movimiento1.setCuentaOrigen(cuenta1);
    	movimiento1.setFecha(cuenta1.getfechaCreacion());
    	movimiento1.setImporte(cuenta1.getSaldo());
    	
    	Movimiento movimiento2 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento2.setIdMovimiento(2);
    	movimiento2.setTipoMovimiento(tipoMovimient1);
    	movimiento2.setCuentaOrigen(cuenta2);
    	movimiento2.setFecha(cuenta2.getfechaCreacion());
    	movimiento2.setImporte(cuenta2.getSaldo());
    	
    	Movimiento movimiento3 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento3.setIdMovimiento(3);
    	movimiento3.setTipoMovimiento(tipoMovimient1);
    	movimiento3.setCuentaOrigen(cuenta3);
    	movimiento3.setFecha(cuenta3.getfechaCreacion());
    	movimiento3.setImporte(cuenta3.getSaldo());
    	
    	Movimiento movimiento4 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento4.setIdMovimiento(4);
    	movimiento4.setTipoMovimiento(tipoMovimient1);
    	movimiento4.setCuentaOrigen(cuenta4);
    	movimiento4.setFecha(cuenta4.getfechaCreacion());
    	movimiento4.setImporte(cuenta4.getSaldo());
    	
    	Movimiento movimiento5 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento5.setIdMovimiento(5);
    	movimiento5.setTipoMovimiento(tipoMovimient1);
    	movimiento5.setCuentaOrigen(cuenta5);
    	movimiento5.setFecha(cuenta5.getfechaCreacion());
    	movimiento5.setImporte(cuenta5.getSaldo());
    	
    	Movimiento movimiento6 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento6.setIdMovimiento(6);
    	movimiento6.setTipoMovimiento(tipoMovimient1);
    	movimiento6.setCuentaOrigen(cuenta6);
    	movimiento6.setFecha(cuenta6.getfechaCreacion());
    	movimiento6.setImporte(cuenta6.getSaldo());
    	
    	Movimiento movimiento7 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento7.setIdMovimiento(7);
    	movimiento7.setTipoMovimiento(tipoMovimient1);
    	movimiento7.setCuentaOrigen(cuenta7);
    	movimiento7.setFecha(cuenta7.getfechaCreacion());
    	movimiento7.setImporte(cuenta7.getSaldo());
    	
    	Movimiento movimiento8 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento8.setIdMovimiento(8);
    	movimiento8.setTipoMovimiento(tipoMovimient1);
    	movimiento8.setCuentaOrigen(cuenta8);
    	movimiento8.setFecha(cuenta8.getfechaCreacion());
    	movimiento8.setImporte(cuenta8.getSaldo());
    	
    	Movimiento movimiento9 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento9.setIdMovimiento(9);
    	movimiento9.setTipoMovimiento(tipoMovimient1);
    	movimiento9.setCuentaOrigen(cuenta9);
    	movimiento9.setFecha(cuenta9.getfechaCreacion());
    	movimiento9.setImporte(cuenta9.getSaldo());
    	
    	Movimiento movimiento10 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento10.setIdMovimiento(10);
    	movimiento10.setTipoMovimiento(tipoMovimient1);
    	movimiento10.setCuentaOrigen(cuenta10);
    	movimiento10.setFecha(cuenta10.getfechaCreacion());
    	movimiento10.setImporte(cuenta10.getSaldo());
    	
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	
    	Movimiento movimiento11 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento11.setIdMovimiento(11);
    	movimiento11.setTipoMovimiento(tipoMovimient4);
    	movimiento11.setCuentaOrigen(cuenta1);
    	movimiento11.setCuentaDestino(cuenta3);
    	movimiento11.setFecha(format.parse("2020-06-23 00:00:00"));
    	movimiento11.setImporte(3500);
    	
    	Movimiento movimiento12 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento12.setIdMovimiento(12);
    	movimiento12.setTipoMovimiento(tipoMovimient4);
    	movimiento12.setCuentaOrigen(cuenta2);
    	movimiento12.setCuentaDestino(cuenta1);
    	movimiento12.setFecha(format.parse("2020-06-24 00:00:00"));
    	movimiento12.setImporte(6000);
    	
    	Movimiento movimiento13 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento13.setIdMovimiento(13);
    	movimiento13.setTipoMovimiento(tipoMovimient2);
    	movimiento13.setCuentaOrigen(cuenta1);
    	movimiento13.setFecha(format.parse("2020-06-25 00:00:00"));
    	movimiento13.setMotivo("Alta de prestamo N°1");
    	movimiento13.setImporte(60000);
    	
    	Movimiento movimiento14 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento14.setIdMovimiento(14);
    	movimiento14.setTipoMovimiento(tipoMovimient2);
    	movimiento14.setCuentaOrigen(cuenta3);
    	movimiento14.setFecha(format.parse("2020-05-25 00:00:00"));
    	movimiento14.setMotivo("Alta de prestamo N°2");
    	movimiento14.setImporte(35000);
    	
    	Movimiento movimiento15 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento15.setIdMovimiento(15);
    	movimiento15.setTipoMovimiento(tipoMovimient2);
    	movimiento15.setCuentaOrigen(cuenta5);
    	movimiento15.setFecha(format.parse("2020-03-15 00:00:00"));
    	movimiento15.setMotivo("Alta de prestamo N°4");
    	movimiento15.setImporte(75000);
    	
    	Movimiento movimiento16 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento16.setIdMovimiento(16);
    	movimiento16.setTipoMovimiento(tipoMovimient4);
    	movimiento16.setCuentaOrigen(cuenta4);
    	movimiento16.setCuentaDestino(cuenta5);
    	movimiento16.setFecha(format.parse("2020-04-25 00:00:00"));
    	movimiento16.setImporte(25600);
  	
    	session.save(movimiento1);
    	session.save(movimiento2);
    	session.save(movimiento3);
    	session.save(movimiento4);
    	session.save(movimiento5);
    	session.save(movimiento6);
    	session.save(movimiento7);
    	session.save(movimiento8);
    	session.save(movimiento9);
    	session.save(movimiento10);
    	session.save(movimiento11);
    	session.save(movimiento12);
    	session.save(movimiento13);
    	session.save(movimiento14);
    	session.save(movimiento15);
    	session.save(movimiento16);
    	
    	//----------------------------------------------------------------
    	/*--CARGO DATOS EN LA TABLA ESTADOSPRESTAMO--*/
    	EstadoPrestamo estado1 = (EstadoPrestamo) appContext.getBean("BEstadoPrestamo");
    	estado1.setId(0);
    	estado1.setDescripcion("Pendiente");
    	
    	EstadoPrestamo estado2 = (EstadoPrestamo) appContext.getBean("BEstadoPrestamo");
    	estado2.setId(1);
    	estado2.setDescripcion("Autorizado");
    	
    	EstadoPrestamo estado3 = (EstadoPrestamo) appContext.getBean("BEstadoPrestamo");
    	estado3.setId(2);
    	estado3.setDescripcion("No autorizado");
    	
    	session.save(estado1);
    	session.save(estado2);
    	session.save(estado3);
    	
    	//----------------------------------------------------------------
    	/*--CARGO DATOS EN LA TABLA PRESTAMOS--*/
    	Prestamo prestamo1 = (Prestamo) appContext.getBean("BPrestamo");
    	prestamo1.setUsuario(usuario4);
    	prestamo1.setMovimiento(movimiento13);
    	prestamo1.setCantidadMeses(3);
    	prestamo1.setImporteTotal(60000);
    	prestamo1.setFechaSolicitud(format.parse("2020-05-24 00:00:00"));
    	prestamo1.setFechaResolucion(format.parse("2020-05-25 00:00:00"));
    	prestamo1.setEstado(estado2);
    	prestamo1.setMontoPagar(75000);    	
    	prestamo1.setCbu(cuenta1);
    	
    	Prestamo prestamo2 = (Prestamo) appContext.getBean("BPrestamo");
    	prestamo2.setUsuario(usuario5);
    	prestamo2.setMovimiento(movimiento14);
    	prestamo2.setCantidadMeses(3);
    	prestamo2.setImporteTotal(35000);
    	prestamo2.setFechaSolicitud(format.parse("2020-05-23 00:00:00"));
    	prestamo2.setFechaResolucion(format.parse("2020-05-25 00:00:00"));
    	prestamo2.setEstado(estado2);
    	prestamo2.setMontoPagar(43750);
    	prestamo2.setCbu(cuenta3);
    	
    	Prestamo prestamo3 = (Prestamo) appContext.getBean("BPrestamo");
    	prestamo3.setUsuario(usuario5);
    	prestamo3.setCantidadMeses(6);
    	prestamo3.setImporteTotal(45000);
    	prestamo3.setFechaSolicitud(format.parse("2020-05-23 00:00:00"));
    	prestamo3.setFechaResolucion(format.parse("2020-05-26 00:00:00"));
    	prestamo3.setEstado(estado3);
    	prestamo3.setMontoPagar(56250);
    	prestamo3.setCbu(cuenta4);
    	 	
    	Prestamo prestamo4 = (Prestamo) appContext.getBean("BPrestamo");
    	prestamo4.setUsuario(usuario6);
    	prestamo4.setMovimiento(movimiento15);
    	prestamo4.setCantidadMeses(12);
    	prestamo4.setImporteTotal(75000);
    	prestamo4.setFechaSolicitud(format.parse("2020-03-13 00:00:00"));
    	prestamo4.setFechaResolucion(format.parse("2020-03-15 00:00:00"));
    	prestamo4.setEstado(estado2);
    	prestamo4.setMontoPagar(93750);
    	prestamo4.setCbu(cuenta5);
    	
    	session.save(prestamo1);
    	session.save(prestamo2);
    	session.save(prestamo3);
    	session.save(prestamo4);
    	
    	//----------------------------------------------------------------
    	/*--CARGO DATOS EN LA TABLA CUOTAS--*/
    	for(int x = 6; x<9; x++) {
    		Cuota cuota = (Cuota) appContext.getBean("BCuota");
    		cuota.setPrestamo(prestamo1);
    		cuota.setFechaVencimiento(format.parse("2020-0" + x + "-25 00:00:00"));
    		cuota.setPagada(false);
    		session.save(cuota);
    	}
    	
    	for(int x = 6; x<9; x++) {
    		Cuota cuota1 = (Cuota) appContext.getBean("BCuota");
    		cuota1.setPrestamo(prestamo2);
    		cuota1.setFechaVencimiento(format.parse("2020-0" + x + "-25 00:00:00"));
    		cuota1.setPagada(false);
    		session.save(cuota1);
    	}
    	
    	for(int x = 4; x<16; x++) {
    		Cuota cuota2 = (Cuota) appContext.getBean("BCuota");
    		cuota2.setPrestamo(prestamo4);
    		if(x <= 12) {
    			cuota2.setFechaVencimiento(format.parse("2020-0" + x + "-25 00:00:00"));    			
    		} else {
    			cuota2.setFechaVencimiento(format.parse("2021-0" + (x-12) + "-25 00:00:00"));   
    		}
    		cuota2.setPagada(false);
    		session.save(cuota2);
    	}
    	//----------------------------------------------------------------
    	session.getTransaction().commit();
    	session.close();
    	((ConfigurableApplicationContext)(appContext)).close();
    	sessionFactory.close();
	}

}

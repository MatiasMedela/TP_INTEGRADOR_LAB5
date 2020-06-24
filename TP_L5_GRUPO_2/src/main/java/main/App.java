package main;

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
    	insertarRegistros(); //Ejecutar solo para crear y llenar la BD.
	}
	
	public static void insertarRegistros() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
    	SessionFactory sessionFactory;
    	Configuration configuration = new Configuration();
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
    	Genero gen1 = new Genero();
    	gen1.setIdGenero(1);
    	gen1.setDescripcion("Femenino");
    	
    	Genero gen2 = new Genero();
    	gen2.setIdGenero(2);
    	gen2.setDescripcion("Masculino");
    	
    	Genero gen3 = new Genero();
    	gen3.setIdGenero(3);
    	gen3.setDescripcion("Otros");
    	
    	session.save(gen1);
    	session.save(gen2);
    	session.save(gen3);
    	//-----------------------------------------------------------
    	/*--CARGO DATOS EN TABLA TIPO CUENTA--*/
    	Tipo_Cuenta tipoCuenta1 = new Tipo_Cuenta();
    	tipoCuenta1.getIdTipoCuenta(1);
    	tipoCuenta1.setMoneda("Pesos");
    	tipoCuenta1.getDescripcion("Caja de ahorro en pesos");
    	
    	Tipo_Cuenta tipoCuenta2 = new Tipo_Cuenta();
    	tipoCuenta2.getIdTipoCuenta(2);
    	tipoCuenta2.setMoneda("Dólares");
    	tipoCuenta2.getDescripcion("Caja de ahorro en dolares");
    	
    	Tipo_Cuenta tipoCuenta3 = new Tipo_Cuenta();
    	tipoCuenta3.getIdTipoCuenta(3);
    	tipoCuenta3.setMoneda("Pesos");
    	tipoCuenta3.getDescripcion("Cuenta corriente");
    	
    	Tipo_Cuenta tipoCuenta4 = new Tipo_Cuenta();
    	tipoCuenta4.getIdTipoCuenta(4);
    	tipoCuenta4.setMoneda("Pesos");
    	tipoCuenta4.getDescripcion("Cuenta corriente especial en pesos");
    	
    	Tipo_Cuenta tipoCuenta5 = new Tipo_Cuenta();
    	tipoCuenta5.getIdTipoCuenta(5);
    	tipoCuenta5.setMoneda("Dólares");
    	tipoCuenta5.getDescripcion("Cuenta corriente especial en dolares");
    	
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
    	/*--CARGO DATOS EN TABLA TIPO MOVIMIENTO--*/
    	Tipo_Movimiento tipoMovimient1 = new Tipo_Movimiento();
    	tipoMovimient1.setIdTipoMovimiento(1);
    	tipoMovimient1.setDescripcion("Alta de cuenta");
    	
    	Tipo_Movimiento tipoMovimient2 = new Tipo_Movimiento();
    	tipoMovimient2.setIdTipoMovimiento(2);
    	tipoMovimient2.setDescripcion("Alta de un prestamo");
    	
    	Tipo_Movimiento tipoMovimient3 = new Tipo_Movimiento();
    	tipoMovimient3.setIdTipoMovimiento(3);
    	tipoMovimient3.setDescripcion("Pago de un prestamo");
    	
    	Tipo_Movimiento tipoMovimient4 = new Tipo_Movimiento();
    	tipoMovimient4.setIdTipoMovimiento(4);
    	tipoMovimient4.setDescripcion("Acreditar transferencia");
    	
    	Tipo_Movimiento tipoMovimient5 = new Tipo_Movimiento();
    	tipoMovimient5.setIdTipoMovimiento(5);
    	tipoMovimient5.setDescripcion("Debitar transferencia");
    	
    	session.save(tipoMovimient1);
    	session.save(tipoMovimient2);
    	session.save(tipoMovimient3);
    	session.save(tipoMovimient4);
    	session.save(tipoMovimient5); 
    	//---------------------------------------------------------------
    	/*--CARGO DATOS TABLA LOCALIDAD*/
    	Localidad local1 = new Localidad();
    	local1.setIdLocalidad(1);
    	local1.setProvincia(prov1);
    	local1.setLocNombre("C.A.B.A");
    	local1.setCodigoPostal("0");
    	
    	Localidad local2 = new Localidad();
    	local2.setIdLocalidad(2);
    	local2.setProvincia(prov2);
    	local2.setLocNombre("AVELLANEDA");
    	local2.setCodigoPostal("1870");
    	
    	Localidad local3 = new Localidad();
    	local3.setIdLocalidad(3);
    	local3.setProvincia(prov2);
    	local3.setLocNombre("DOCK SUD");
    	local3.setCodigoPostal("1871");
    	
    	Localidad local4 = new Localidad();
    	local4.setIdLocalidad(4);
    	local4.setProvincia(prov2);
    	local4.setLocNombre("SAN JOSE");
    	local4.setCodigoPostal("6665");
    	
    	Localidad local5 = new Localidad();
    	local5.setIdLocalidad(5);
    	local5.setProvincia(prov2);
    	local5.setLocNombre("LOS PATOS");
    	local5.setCodigoPostal("7603");
    	
    	Localidad local6 = new Localidad();
    	local6.setIdLocalidad(6);
    	local6.setProvincia(prov2);
    	local6.setLocNombre("MIRAMAR");
    	local6.setCodigoPostal("7607");
    	
    	Localidad local7 = new Localidad();
    	local7.setIdLocalidad(7);
    	local7.setProvincia(prov2);
    	local7.setLocNombre("GENERAL ALVEAR");
    	local7.setCodigoPostal("7263");
    	
    	Localidad local8 = new Localidad();
    	local8.setIdLocalidad(8);
    	local8.setProvincia(prov2);
    	local8.setLocNombre("VILLA CERRITO");
    	local8.setCodigoPostal("8000");
    	
    	Localidad local9 = new Localidad();
    	local9.setIdLocalidad(9);
    	local9.setProvincia(prov2);
    	local9.setLocNombre("ALSINA");
    	local9.setCodigoPostal("2938");
    	
    	Localidad local10 = new Localidad();
    	local10.setIdLocalidad(10);
    	local10.setProvincia(prov2);
    	local10.setLocNombre("MONTE CRESPO");
    	local10.setCodigoPostal("7020");
    	
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
    	//---------------------------------------------------------------
    	/*--CARGO DATOS EN TABLA USUARIO--*/
    	Usuario usuario1 = new Usuario();
    	usuario1.setIdUsu("38456789");
    	usuario1.setTipoUsu(tipoUsuario1);
    	usuario1.setGen(gen1);
    	usuario1.setLocalidad(local5);
    	usuario1.setNombre("Daniela");
    	usuario1.setApellido("Alessio");
    	usuario1.setFechaNac(new Date());
    	usuario1.setEstado(false);
    	usuario1.setDireccion("Mosconi 556");
    	usuario1.setE_Mail("dalessio@gmail.com");
    	
    	Usuario usuario2 = new Usuario();
    	usuario2.setIdUsu("38325465");
    	usuario2.setTipoUsu(tipoUsuario2);
    	usuario2.setGen(gen2);
    	usuario2.setLocalidad(local3);
    	usuario2.setNombre("Juan");
    	usuario2.setApellido("Cassano");
    	usuario2.setFechaNac(new Date());
    	usuario2.setEstado(false);
    	usuario2.setDireccion("Riobamba 126");
    	usuario2.setE_Mail("jcasano@gmail.com");
    	
    	Usuario usuario3 = new Usuario();
    	usuario3.setIdUsu("38568454");
    	usuario3.setTipoUsu(tipoUsuario2);
    	usuario3.setGen(gen2);
    	usuario3.setLocalidad(local1);
    	usuario3.setNombre("Leandro");
    	usuario3.setApellido("Lescano");
    	usuario3.setFechaNac(new Date());
    	usuario3.setEstado(false);
    	usuario3.setDireccion("Alsina 236");
    	usuario3.setE_Mail("llescano@gmail.com");
    	
    	Usuario usuario4 = new Usuario();
    	usuario4.setIdUsu("38326854");
    	usuario4.setTipoUsu(tipoUsuario2);
    	usuario4.setGen(gen2);
    	usuario4.setLocalidad(local2);
    	usuario4.setNombre("Sebastian");
    	usuario4.setApellido("Font");
    	usuario4.setFechaNac(new Date());
    	usuario4.setEstado(false);
    	usuario4.setDireccion("General Paz 546");
    	usuario4.setE_Mail("sfont@gmail.com");
    	
    	Usuario usuario5 = new Usuario();
    	usuario5.setIdUsu("38785326");
    	usuario5.setTipoUsu(tipoUsuario2);
    	usuario5.setGen(gen2);
    	usuario5.setLocalidad(local4);
    	usuario5.setNombre("Matias");
    	usuario5.setApellido("Medela");
    	usuario5.setFechaNac(new Date());
    	usuario5.setEstado(false);
    	usuario5.setDireccion("Mosconi 546");
    	usuario5.setE_Mail("mmedela@gmail.com");
    	
    	Usuario usuario6 = new Usuario();
    	usuario6.setIdUsu("4236552");
    	usuario6.setTipoUsu(tipoUsuario2);
    	usuario6.setGen(gen2);
    	usuario6.setLocalidad(local3);
    	usuario6.setNombre("Juan");
    	usuario6.setApellido("de Lage");
    	usuario6.setFechaNac(new Date());
    	usuario6.setEstado(false);
    	usuario6.setDireccion("Haedo 652");
    	usuario6.setE_Mail("jjlage@gmail.com");
    	
    	Usuario usuario7 = new Usuario();
    	usuario7.setIdUsu("6235645");
    	usuario7.setTipoUsu(tipoUsuario2);
    	usuario7.setGen(gen2);
    	usuario7.setLocalidad(local3);
    	usuario7.setNombre("Horacio");
    	usuario7.setApellido("Suarez");
    	usuario7.setFechaNac(new Date());
    	usuario7.setEstado(false);
    	usuario7.setDireccion("Av. Centenario 1256");
    	usuario7.setE_Mail("hsuarez@gmail.com");
    	
    	Usuario usuario8 = new Usuario();
    	usuario8.setIdUsu("4237365");
    	usuario8.setTipoUsu(tipoUsuario2);
    	usuario8.setGen(gen1);
    	usuario8.setLocalidad(local3);
    	usuario8.setNombre("Olga");
    	usuario8.setApellido("Capotosti");
    	usuario8.setFechaNac(new Date());
    	usuario8.setEstado(false);
    	usuario8.setDireccion("Haedo 568");
    	usuario8.setE_Mail("ocapotosti@gmail.com");
    	
    	Usuario usuario9 = new Usuario();
    	usuario9.setIdUsu("37234456");
    	usuario9.setTipoUsu(tipoUsuario2);
    	usuario9.setGen(gen1);
    	usuario9.setLocalidad(local4);
    	usuario9.setNombre("Marisa");
    	usuario9.setApellido("Vasquez");
    	usuario9.setFechaNac(new Date());
    	usuario9.setEstado(false);
    	usuario9.setDireccion("Alsina 326");
    	usuario9.setE_Mail("mvasquez@gmail.com");
    	
    	Usuario usuario10 = new Usuario();
    	usuario10.setIdUsu("36798546");
    	usuario10.setTipoUsu(tipoUsuario2);
    	usuario10.setGen(gen2);
    	usuario10.setLocalidad(local4);
    	usuario10.setNombre("Mariano");
    	usuario10.setApellido("Vivas");
    	usuario10.setFechaNac(new Date());
    	usuario10.setEstado(false);
    	usuario10.setDireccion("Julian Navarro 135");
    	usuario10.setE_Mail("mvivas@gmail.com");
    	
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
    	Logueo log1 = new Logueo();
    	log1.setNUsuario(usuario1.getE_Mail());
    	log1.setContrasenia(usuario1.getIdUsu());
    	log1.setUsuario(usuario1);
    	
    	Logueo log2 = new Logueo();
    	log2.setNUsuario(usuario2.getE_Mail());
    	log2.setContrasenia(usuario2.getIdUsu());
    	log2.setUsuario(usuario2);
    	
    	Logueo log3 = new Logueo();
    	log3.setNUsuario(usuario3.getE_Mail());
    	log3.setContrasenia(usuario3.getIdUsu());
    	log3.setUsuario(usuario3);
    	
    	Logueo log4 = new Logueo();
    	log4.setNUsuario(usuario4.getE_Mail());
    	log4.setContrasenia(usuario4.getIdUsu());
    	log4.setUsuario(usuario4);
    	
    	Logueo log5 = new Logueo();
    	log5.setNUsuario(usuario5.getE_Mail());
    	log5.setContrasenia(usuario5.getIdUsu());
    	log5.setUsuario(usuario5);
    	
    	Logueo log6 = new Logueo();
    	log6.setNUsuario(usuario6.getE_Mail());
    	log6.setContrasenia(usuario6.getIdUsu());
    	log6.setUsuario(usuario6);
    	
    	Logueo log7 = new Logueo();
    	log7.setNUsuario(usuario7.getE_Mail());
    	log7.setContrasenia(usuario7.getIdUsu());
    	log7.setUsuario(usuario7);
    	
    	Logueo log8 = new Logueo();
    	log8.setNUsuario(usuario8.getE_Mail());
    	log8.setContrasenia(usuario8.getIdUsu());
    	log8.setUsuario(usuario8);
    	
    	Logueo log9 = new Logueo();
    	log9.setNUsuario(usuario9.getE_Mail());
    	log9.setContrasenia(usuario9.getIdUsu());
    	log9.setUsuario(usuario9);
    	
    	Logueo log10 = new Logueo();
    	log10.setNUsuario(usuario10.getE_Mail());
    	log10.setContrasenia(usuario10.getIdUsu());
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
    	Cuenta cuenta1 = new Cuenta();
    	cuenta1.setIdCuenta(1);
    	cuenta1.setTipoCuenta(tipoCuenta2);
    	cuenta1.setFechaCreacion("09/06/2020");
    	cuenta1.setCbu("0000.0000.0001");
    	cuenta1.setAlias("GeneralPacheco2020");
    	cuenta1.setUsuario(usuario4);
    	cuenta1.setSaldo(10000);
    	cuenta1.setEstado(false);
    	
    	Cuenta cuenta2 = new Cuenta();
    	cuenta2.setIdCuenta(2);
    	cuenta2.setTipoCuenta(tipoCuenta3);
    	cuenta2.setFechaCreacion("09/06/2020");
    	cuenta2.setCbu("0000.0000.0002");
    	cuenta2.setAlias("GeneralPacheco202");
    	cuenta2.setUsuario(usuario4);
    	cuenta2.setSaldo(10000);
    	cuenta2.setEstado(false);
    	
    	Cuenta cuenta3 = new Cuenta();
    	cuenta3.setIdCuenta(3);
    	cuenta3.setTipoCuenta(tipoCuenta2);
    	cuenta3.setFechaCreacion("09/06/2020");
    	cuenta3.setCbu("0000.0000.0003");
    	cuenta3.setAlias("WinterGarden2012");
    	cuenta3.setUsuario(usuario5);
    	cuenta3.setSaldo(10000);
    	cuenta3.setEstado(false);
    	
    	Cuenta cuenta4 = new Cuenta();
    	cuenta4.setIdCuenta(4);
    	cuenta4.setTipoCuenta(tipoCuenta3);
    	cuenta4.setFechaCreacion("09/06/2020");
    	cuenta4.setCbu("0000.0000.0004");
    	cuenta4.setAlias("WinterGarden2013");
    	cuenta4.setUsuario(usuario5);
    	cuenta4.setSaldo(10000);
    	cuenta4.setEstado(false);
    	
    	Cuenta cuenta5 = new Cuenta();
    	cuenta5.setIdCuenta(5);
    	cuenta5.setTipoCuenta(tipoCuenta2);
    	cuenta5.setFechaCreacion("09/06/2020");
    	cuenta5.setCbu("0000.0000.0005");
    	cuenta5.setAlias("LaRalde3256");
    	cuenta5.setUsuario(usuario6);
    	cuenta5.setSaldo(10000);
    	cuenta5.setEstado(false);
    	
    	Cuenta cuenta6 = new Cuenta();
    	cuenta6.setIdCuenta(6);
    	cuenta6.setTipoCuenta(tipoCuenta3);
    	cuenta6.setFechaCreacion("09/06/2020");
    	cuenta6.setCbu("0000.0000.0006");
    	cuenta6.setAlias("LaRalde3245");
    	cuenta6.setUsuario(usuario6);
    	cuenta6.setSaldo(10000);
    	cuenta6.setEstado(false);
    	
    	Cuenta cuenta7 = new Cuenta();
    	cuenta7.setIdCuenta(7);
    	cuenta7.setTipoCuenta(tipoCuenta2);
    	cuenta7.setFechaCreacion("09/06/2020");
    	cuenta7.setCbu("0000.0000.0007");
    	cuenta7.setAlias("River2014");;
    	cuenta7.setUsuario(usuario7);
    	cuenta7.setSaldo(10000);
    	cuenta7.setEstado(false);
    	
    	Cuenta cuenta8 = new Cuenta();
    	cuenta8.setIdCuenta(8);
    	cuenta8.setTipoCuenta(tipoCuenta3);
    	cuenta8.setFechaCreacion("09/06/2020");
    	cuenta8.setCbu("0000.0000.0008");
    	cuenta8.setAlias("River2015");
    	cuenta8.setUsuario(usuario7);
    	cuenta8.setSaldo(10000);
    	cuenta8.setEstado(false);
    	
    	Cuenta cuenta9 = new Cuenta();
    	cuenta9.setIdCuenta(9);
    	cuenta9.setTipoCuenta(tipoCuenta2);
    	cuenta9.setFechaCreacion("09/06/2020");
    	cuenta9.setCbu("0000.0000.0009");
    	cuenta9.setUsuario(usuario8);
    	cuenta9.setAlias("Boca2007");
    	cuenta9.setSaldo(10000);
    	cuenta9.setEstado(false);
    	
    	Cuenta cuenta10 = new Cuenta();
    	cuenta10.setIdCuenta(10);
    	cuenta10.setTipoCuenta(tipoCuenta3);
    	cuenta10.setFechaCreacion("09/06/2020");
    	cuenta10.setCbu("0000.0000.0010");
    	cuenta10.setAlias("Boca2006");
    	cuenta10.setUsuario(usuario8);
    	cuenta10.setSaldo(10000);
    	cuenta10.setEstado(false);
    	
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
    	Movimiento movimiento1 =new Movimiento();
    	movimiento1.setIdMovimiento(1);
    	movimiento1.setTipoMovimiento(tipoMovimient1);
    	movimiento1.setCbuOrigen(cuenta1.getCbu());
    	movimiento1.setFecha(cuenta1.getFechaCreacion());
    	movimiento1.setImporte(cuenta1.getSaldo());
    	
    	Movimiento movimiento2 =new Movimiento();
    	movimiento2.setIdMovimiento(2);
    	movimiento2.setTipoMovimiento(tipoMovimient1);
    	movimiento2.setCbuOrigen(cuenta2.getCbu());
    	movimiento2.setFecha(cuenta2.getFechaCreacion());
    	movimiento2.setImporte(cuenta2.getSaldo());
    	
    	Movimiento movimiento3 =new Movimiento();
    	movimiento3.setIdMovimiento(3);
    	movimiento3.setTipoMovimiento(tipoMovimient1);
    	movimiento3.setCbuOrigen(cuenta3.getCbu());
    	movimiento3.setFecha(cuenta3.getFechaCreacion());
    	movimiento3.setImporte(cuenta3.getSaldo());
    	
    	Movimiento movimiento4 =new Movimiento();
    	movimiento4.setIdMovimiento(4);
    	movimiento4.setTipoMovimiento(tipoMovimient1);
    	movimiento4.setCbuOrigen(cuenta4.getCbu());
    	movimiento4.setFecha(cuenta4.getFechaCreacion());
    	movimiento4.setImporte(cuenta4.getSaldo());
    	
    	Movimiento movimiento5 =new Movimiento();
    	movimiento5.setIdMovimiento(5);
    	movimiento5.setTipoMovimiento(tipoMovimient1);
    	movimiento5.setCbuOrigen(cuenta5.getCbu());
    	movimiento5.setFecha(cuenta5.getFechaCreacion());
    	movimiento5.setImporte(cuenta5.getSaldo());
    	
    	Movimiento movimiento6 =new Movimiento();
    	movimiento6.setIdMovimiento(6);
    	movimiento6.setTipoMovimiento(tipoMovimient1);
    	movimiento6.setCbuOrigen(cuenta6.getCbu());
    	movimiento6.setFecha(cuenta6.getFechaCreacion());
    	movimiento6.setImporte(cuenta6.getSaldo());
    	
    	Movimiento movimiento7 =new Movimiento();
    	movimiento7.setIdMovimiento(7);
    	movimiento7.setTipoMovimiento(tipoMovimient1);
    	movimiento7.setCbuOrigen(cuenta7.getCbu());
    	movimiento7.setFecha(cuenta7.getFechaCreacion());
    	movimiento7.setImporte(cuenta7.getSaldo());
    	
    	Movimiento movimiento8 =new Movimiento();
    	movimiento8.setIdMovimiento(8);
    	movimiento8.setTipoMovimiento(tipoMovimient1);
    	movimiento8.setCbuOrigen(cuenta8.getCbu());
    	movimiento8.setFecha(cuenta8.getFechaCreacion());
    	movimiento8.setImporte(cuenta8.getSaldo());
    	
    	Movimiento movimiento9 =new Movimiento();
    	movimiento9.setIdMovimiento(9);
    	movimiento9.setTipoMovimiento(tipoMovimient1);
    	movimiento9.setCbuOrigen(cuenta9.getCbu());
    	movimiento9.setFecha(cuenta9.getFechaCreacion());
    	movimiento9.setImporte(cuenta9.getSaldo());
    	
    	Movimiento movimiento10 =new Movimiento();
    	movimiento10.setIdMovimiento(10);
    	movimiento10.setTipoMovimiento(tipoMovimient1);
    	movimiento10.setCbuOrigen(cuenta10.getCbu());
    	movimiento10.setFecha(cuenta10.getFechaCreacion());
    	movimiento10.setImporte(cuenta10.getSaldo());
  	
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

    	//----------------------------------------------------------------
    	session.getTransaction().commit();
    	session.close();
    	((ConfigurableApplicationContext)(appContext)).close();
    	sessionFactory.close();
	}

}

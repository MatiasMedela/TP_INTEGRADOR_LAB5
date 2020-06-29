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
    	tipoMovimient4.setDescripcion("Acreditar transferencia");
    	
    	Tipo_Movimiento tipoMovimient5 = (Tipo_Movimiento) appContext.getBean("BTipo_Movimiento");
    	tipoMovimient5.setIdTipoMovimiento(5);
    	tipoMovimient5.setDescripcion("Debitar transferencia");
    	
    	session.save(tipoMovimient1);
    	session.save(tipoMovimient2);
    	session.save(tipoMovimient3);
    	session.save(tipoMovimient4);
    	session.save(tipoMovimient5); 
    	//---------------------------------------------------------------
    	/*--CARGO DATOS TABLA LOCALIDAD*/
    	Localidad local1 = (Localidad) appContext.getBean("BLocalidad");
    	local1.setIdLocalidad(1);
    	local1.setProvLoc(prov1);
    	local1.setLocNombre("C.A.B.A");
    	local1.setCodigoPostal("0");
    	
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
    	
    	Localidad local4 = (Localidad) appContext.getBean("BLocalidad");
    	local4.setIdLocalidad(4);
    	local4.setProvLoc(prov2);
    	local4.setLocNombre("SAN JOSE");
    	local4.setCodigoPostal("6665");
    	
    	Localidad local5 = (Localidad) appContext.getBean("BLocalidad");
    	local5.setIdLocalidad(5);
    	local5.setProvLoc(prov2);
    	local5.setLocNombre("LOS PATOS");
    	local5.setCodigoPostal("7603");
    	
    	Localidad local6 = (Localidad) appContext.getBean("BLocalidad");
    	local6.setIdLocalidad(6);
    	local6.setProvLoc(prov2);
    	local6.setLocNombre("MIRAMAR");
    	local6.setCodigoPostal("7607");
    	
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
    	log1.setContrasenia("pppp");
    	log1.setUsuario(usuario1);
    	
    	Logueo log2 = (Logueo) appContext.getBean("BLogueo");
    	log2.setNUsuario(usuario2.getEmail());
    	log2.setContrasenia("pppp");
    	log2.setUsuario(usuario2);
    	
    	Logueo log3 = (Logueo) appContext.getBean("BLogueo");
    	log3.setNUsuario(usuario3.getEmail());
    	log3.setContrasenia("pppp");
    	log3.setUsuario(usuario3);
    	
    	Logueo log4 = (Logueo) appContext.getBean("BLogueo");
    	log4.setNUsuario(usuario4.getEmail());
    	log4.setContrasenia("pppp");
    	log4.setUsuario(usuario4);
    	
    	Logueo log5 = (Logueo) appContext.getBean("BLogueo");
    	log5.setNUsuario(usuario5.getEmail());
    	log5.setContrasenia("pppp");
    	log5.setUsuario(usuario5);
    	
    	Logueo log6 = (Logueo) appContext.getBean("BLogueo");
    	log6.setNUsuario(usuario6.getEmail());
    	log6.setContrasenia("pppp");
    	log6.setUsuario(usuario6);
    	
    	Logueo log7 = (Logueo) appContext.getBean("BLogueo");
    	log7.setNUsuario(usuario7.getEmail());
    	log7.setContrasenia("pppp");
    	log7.setUsuario(usuario7);
    	
    	Logueo log8 = (Logueo) appContext.getBean("BLogueo");
    	log8.setNUsuario(usuario8.getEmail());
    	log8.setContrasenia("pppp");
    	log8.setUsuario(usuario8);
    	
    	Logueo log9 = (Logueo) appContext.getBean("BLogueo");
    	log9.setNUsuario(usuario9.getEmail());
    	log9.setContrasenia("pppp");
    	log9.setUsuario(usuario9);
    	
    	Logueo log10 = (Logueo) appContext.getBean("BLogueo");
    	log10.setNUsuario(usuario10.getEmail());
    	log10.setContrasenia("pppp");
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
    	movimiento1.setCbuOrigen(cuenta1.getCbu());
    	movimiento1.setFecha(cuenta1.getfechaCreacion());
    	movimiento1.setImporte(cuenta1.getSaldo());
    	
    	Movimiento movimiento2 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento2.setIdMovimiento(2);
    	movimiento2.setTipoMovimiento(tipoMovimient1);
    	movimiento2.setCbuOrigen(cuenta2.getCbu());
    	movimiento2.setFecha(cuenta2.getfechaCreacion());
    	movimiento2.setImporte(cuenta2.getSaldo());
    	
    	Movimiento movimiento3 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento3.setIdMovimiento(3);
    	movimiento3.setTipoMovimiento(tipoMovimient1);
    	movimiento3.setCbuOrigen(cuenta3.getCbu());
    	movimiento3.setFecha(cuenta3.getfechaCreacion());
    	movimiento3.setImporte(cuenta3.getSaldo());
    	
    	Movimiento movimiento4 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento4.setIdMovimiento(4);
    	movimiento4.setTipoMovimiento(tipoMovimient1);
    	movimiento4.setCbuOrigen(cuenta4.getCbu());
    	movimiento4.setFecha(cuenta4.getfechaCreacion());
    	movimiento4.setImporte(cuenta4.getSaldo());
    	
    	Movimiento movimiento5 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento5.setIdMovimiento(5);
    	movimiento5.setTipoMovimiento(tipoMovimient1);
    	movimiento5.setCbuOrigen(cuenta5.getCbu());
    	movimiento5.setFecha(cuenta5.getfechaCreacion());
    	movimiento5.setImporte(cuenta5.getSaldo());
    	
    	Movimiento movimiento6 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento6.setIdMovimiento(6);
    	movimiento6.setTipoMovimiento(tipoMovimient1);
    	movimiento6.setCbuOrigen(cuenta6.getCbu());
    	movimiento6.setFecha(cuenta6.getfechaCreacion());
    	movimiento6.setImporte(cuenta6.getSaldo());
    	
    	Movimiento movimiento7 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento7.setIdMovimiento(7);
    	movimiento7.setTipoMovimiento(tipoMovimient1);
    	movimiento7.setCbuOrigen(cuenta7.getCbu());
    	movimiento7.setFecha(cuenta7.getfechaCreacion());
    	movimiento7.setImporte(cuenta7.getSaldo());
    	
    	Movimiento movimiento8 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento8.setIdMovimiento(8);
    	movimiento8.setTipoMovimiento(tipoMovimient1);
    	movimiento8.setCbuOrigen(cuenta8.getCbu());
    	movimiento8.setFecha(cuenta8.getfechaCreacion());
    	movimiento8.setImporte(cuenta8.getSaldo());
    	
    	Movimiento movimiento9 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento9.setIdMovimiento(9);
    	movimiento9.setTipoMovimiento(tipoMovimient1);
    	movimiento9.setCbuOrigen(cuenta9.getCbu());
    	movimiento9.setFecha(cuenta9.getfechaCreacion());
    	movimiento9.setImporte(cuenta9.getSaldo());
    	
    	Movimiento movimiento10 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento10.setIdMovimiento(10);
    	movimiento10.setTipoMovimiento(tipoMovimient1);
    	movimiento10.setCbuOrigen(cuenta10.getCbu());
    	movimiento10.setFecha(cuenta10.getfechaCreacion());
    	movimiento10.setImporte(cuenta10.getSaldo());
    	
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	
    	Movimiento movimiento11 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento11.setIdMovimiento(11);
    	movimiento11.setTipoMovimiento(tipoMovimient5);
    	movimiento11.setCbuOrigen(cuenta1.getCbu());
    	movimiento11.setFecha(format.parse("2020-06-23 00:00:00"));
    	movimiento11.setImporte(3500);
    	
    	Movimiento movimiento12 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento12.setIdMovimiento(12);
    	movimiento12.setTipoMovimiento(tipoMovimient5);
    	movimiento12.setCbuOrigen(cuenta2.getCbu());
    	movimiento12.setFecha(format.parse("2020-06-24 00:00:00"));
    	movimiento12.setImporte(6000);
    	
    	Movimiento movimiento13 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento13.setIdMovimiento(13);
    	movimiento13.setTipoMovimiento(tipoMovimient2);
    	movimiento13.setCbuOrigen(cuenta1.getCbu());
    	movimiento13.setFecha(format.parse("2020-06-25 00:00:00"));
    	movimiento13.setImporte(60000);
    	
    	Movimiento movimiento14 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento14.setIdMovimiento(14);
    	movimiento14.setTipoMovimiento(tipoMovimient2);
    	movimiento14.setCbuOrigen(cuenta3.getCbu());
    	movimiento14.setFecha(format.parse("2020-05-25 00:00:00"));
    	movimiento14.setImporte(35000);
    	
    	Movimiento movimiento15 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento15.setIdMovimiento(15);
    	movimiento15.setTipoMovimiento(tipoMovimient2);
    	movimiento15.setCbuOrigen(cuenta5.getCbu());
    	movimiento15.setFecha(format.parse("2020-03-15 00:00:00"));
    	movimiento15.setImporte(75000);
    	
    	Movimiento movimiento16 =(Movimiento) appContext.getBean("BMovimiento");
    	movimiento16.setIdMovimiento(16);
    	movimiento16.setTipoMovimiento(tipoMovimient5);
    	movimiento16.setCbuOrigen(cuenta4.getCbu());
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
    	/*--CARGO DATOS EN LA TABLA TRANSFERENCIAS--*/
    	Transferencia transferencia1 = (Transferencia) appContext.getBean("BTransferencia");
    	transferencia1.setCbuDestino(3);
    	transferencia1.setMovimiento(movimiento11);
    	
    	Transferencia transferencia2 = (Transferencia) appContext.getBean("BTransferencia");
    	transferencia2.setCbuDestino(1);
    	transferencia2.setMovimiento(movimiento12);
    	
    	Transferencia transferencia3 = (Transferencia) appContext.getBean("BTransferencia");
    	transferencia3.setCbuDestino(5);
    	transferencia3.setMovimiento(movimiento16);
    	
    	session.save(transferencia1);
    	session.save(transferencia2);
    	session.save(transferencia3);
    	
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
    	prestamo1.setEstado(estado2);
    	prestamo1.setMontoPagar(75000);    	
    	prestamo1.setCbu(cuenta1);
    	
    	Prestamo prestamo2 = (Prestamo) appContext.getBean("BPrestamo");
    	prestamo2.setUsuario(usuario5);
    	prestamo2.setMovimiento(movimiento14);
    	prestamo2.setCantidadMeses(3);
    	prestamo2.setImporteTotal(35000);
    	prestamo2.setEstado(estado2);
    	prestamo2.setMontoPagar(43750);
    	prestamo2.setCbu(cuenta3);
    	
    	Prestamo prestamo3 = (Prestamo) appContext.getBean("BPrestamo");
    	prestamo3.setUsuario(usuario5);
    	prestamo3.setCantidadMeses(6);
    	prestamo3.setImporteTotal(45000);
    	prestamo3.setEstado(estado3);
    	prestamo3.setMontoPagar(56250);
    	prestamo3.setCbu(cuenta4);
    	 	
    	Prestamo prestamo4 = (Prestamo) appContext.getBean("BPrestamo");
    	prestamo4.setUsuario(usuario6);
    	prestamo4.setMovimiento(movimiento16);
    	prestamo4.setCantidadMeses(12);
    	prestamo4.setImporteTotal(75000);
    	prestamo4.setEstado(estado2);
    	prestamo4.setMontoPagar(93750);
    	prestamo4.setCbu(cuenta5);
    	
    	session.save(prestamo1);
    	session.save(prestamo2);
    	session.save(prestamo3);
    	session.save(prestamo4);
    	//----------------------------------------------------------------
    	session.getTransaction().commit();
    	session.close();
    	((ConfigurableApplicationContext)(appContext)).close();
    	sessionFactory.close();
	}

}

package Vista;

import java.util.Scanner;
import java.util.ArrayList;
import ModeloImp.*;
import Controladores.ControladorPersonasInput;
import Controladores.ControladorPersonasBussiness;
import Controladores.ControladorSocioBussiness;
import Controladores.ControladorAutorizadoBussiness;
import Controladores.ControladorClubBussiness;
import Controladores.ControladorFacturasInput;
import Controladores.ControladorFacturasBussiness;
import ControladoresImp.ControladorBussinessInputImp;
import ControladoresImp.ControladorBussinessImp;
import ControladoresImp.ControladorInputImp;

public class principal {

	public static void main(String[] args) {

		Club gocClub = new Club(new ArrayList<Socio>());
		Scanner input = new Scanner(System.in);
		boolean ejecucion = true;
		String menu = "\n             GocClub              "
					+ "\n_______________Menú_______________"
					+ "\nIngrese el nùmero que corresponda a la acción"
					+ "\nque requiera:"
					+ "\n1. Afiliar un socio"
					+ "\n2. Eliminar un socio"
					+ "\n3. Registrar un autorizado"
					+ "\n4. Eliminar un autorizado"
					+ "\n5. Registrar consumo a un socio"
					+ "\n6. Pagar una factura de un socio"
					+ "\n7. Registrar consumo a un autorizado"					
					+ "\n8. Pagar una factura de un autorizado"
					+ "\n9. Aumentar fondos a un socio"
					+ "\n10. Menú de muestra de datos"
					+ "\n0. Salir del programa";
		
		ControladorInputImp controladorInput = new ControladorInputImp();
		
		while (ejecucion) {
			try {
				
				System.out.println(menu);
				int opcion = controladorInput.integerValido(input.next(), "La opción que ingreso");
				
				switch(opcion) {
					case 0:
						System.out.println("Usted ha elegido salir del programa.");
						ejecucion = false;
						input.close();
						break;
						
					case 1: {
						ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
						ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
						ControladorClubBussiness clubBussiness = new ControladorBussinessImp();
						ControladorSocioBussiness socioBussiness = new ControladorBussinessImp();
						
						System.out.println("\n***************Afiliar socio***************");
						
						System.out.println("Ingrese el nombre de la persona que se quiere afiliar: ");
						String nombre = personasInput.validarNombre(input.next());
						
						System.out.println("Ingrese la cedula de la persona que se quiere afiliar: ");
						int cedula = personasInput.validarCedula(input.next());
						personasBussiness.descartarCedulaEnSocios(gocClub.getSocios(), cedula);
						personasBussiness.descartarCedulaEnAutorizados(gocClub.getSocios(), cedula);
							
						System.out.println("Ingrese el tipo de suscripciòn al que quiere pertenecer"
										 + "\nDigite el nùmero que corresponda:"
										 + "\n1. VIP"
										 + "\n2. Regular: ");
						String tipoDeSuscripcion = personasInput.validarTipoDeSuscripcion(input.next());
						socioBussiness.validarCupoParaSocio(tipoDeSuscripcion, gocClub.getSocios());
						
						System.out.println("Ingrese con cuantos fondos se quiere registrar: ");
						double fondos = personasInput.validarFondos(input.next());
						clubBussiness.validarTopeMinimo(tipoDeSuscripcion, fondos);
						clubBussiness.validarTopeMaximo(tipoDeSuscripcion, fondos);
						
						Socio socio = new Socio(cedula, nombre, fondos, tipoDeSuscripcion);
						
						gocClub.setSocio(socio);
						
						System.out.println("************Se afilio con éxito************");
						break;
					}	
					case 2: {
						ControladorSocioBussiness socioBussiness = new ControladorBussinessImp();
						ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
						
						System.out.println("\n***************Eliminar socio***************");
						System.out.println("Ingrese la cedula del socio que se quiere eliminar: ");
						int cedula = personasInput.validarCedula(input.next());
						socioBussiness.eliminarSocio(gocClub.getSocios(), cedula);
						System.out.println("\n*********Socio eliminado con éxito**********");
						break;
					}	
					case 3: {
						ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
						ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
						ControladorAutorizadoBussiness autorizadoBussiness = new ControladorBussinessImp();
						ControladorClubBussiness clubBussiness = new ControladorBussinessImp();
						
						System.out.println("\n***************Registrar autorizado***************");
						System.out.println("Ingrese el nombre de la persona que se quiere registrar: ");
						String nombre = personasInput.validarNombre(input.next());
						
						System.out.println("Ingrese la cedula de la persona que se quiere registrar: ");
						int cedula = personasInput.validarCedula(input.next());
						personasBussiness.descartarCedulaEnSocios(gocClub.getSocios(), cedula);
						personasBussiness.descartarCedulaEnAutorizados(gocClub.getSocios(), cedula);
						
						System.out.println("Ingrese la cedula del socio que quiere registrar un autorizado: ");
						Socio socio = personasBussiness.buscarSocio(gocClub.getSocios(), personasInput.validarCedula(input.next()));
						autorizadoBussiness.validarCupoParaAutorizado(socio);
						clubBussiness.validarFondosSuficientes(1d, socio.getFondos());
						
						Autorizado autorizado = new Autorizado(cedula, nombre);
						socio.setAutorizado(autorizado);
						
						System.out.println("\n***************Se registro con éxito**************");
						
						break;
					}	
					case 4: {
						ControladorAutorizadoBussiness autorizadoBussiness = new ControladorBussinessImp();
						ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
						
						System.out.println("\n***************Eliminar autorizado***************");
						System.out.println("Ingrese la cedula del autorizado que se quiere eliminar: ");
						int cedula = personasInput.validarCedula(input.next());
						autorizadoBussiness.eliminarAutorizado(gocClub.getSocios(), cedula);
						System.out.println("\n*********Autorizado eliminado con éxito**********");
						break;
					}	
					case 5: {
						ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
						ControladorFacturasInput facturasInput = new ControladorBussinessInputImp();
						ControladorFacturasBussiness facturasBussiness = new ControladorBussinessImp();
						ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
						ControladorClubBussiness clubBussiness = new ControladorBussinessImp();
						
						System.out.println("\n*********Registrar consumo a socio*********");
						System.out.println("Ingrese la cedula del socio que quiere registrar un consumo: ");
						Socio socio = personasBussiness.buscarSocio(gocClub.getSocios(), personasInput.validarCedula(input.next()));
						facturasBussiness.validarNumeroDeFacturas(socio.getFacturas());
						
						System.out.println("Ingrese el concepto consumo (nombre de lo que consumio): ");
						String conceptoConsumo = facturasInput.validarConceptoConsumo(input.next());
						
						System.out.println("Ingrese el valor de lo que consumio: ");
						double valor = facturasInput.validarValor(input.next());
						clubBussiness.validarFondosSuficientes(valor, socio.getFondos());
						
						Factura factura = new Factura(socio.getNombre(), conceptoConsumo, valor);
						socio.setFactura(factura);
						
						System.out.println("\n******Se registro el consumo con éxito*****");
						
						break;
					}
					case 6: {
						ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
						ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
						ControladorFacturasBussiness facturaBussiness = new ControladorBussinessImp();
						
						System.out.println("\n***************Pagar factura de socio***************");
						System.out.println("Ingrese la cedula del socio que desea pagar una factura: ");
						Socio socio = personasBussiness.buscarSocio(gocClub.getSocios(), personasInput.validarCedula(input.next()));
						facturaBussiness.validarFacturasPendientes(socio.getFacturas());
						System.out.println("\n____________Facturas pendientes_____________");
						System.out.println(socio.mostrarFacturas());
						System.out.println("Ingrese el nùmero de la factura que desea pagar: ");
						int numeroDeFactura = controladorInput.integerValido(input.next(), "El nùmero que ingreso");
						facturaBussiness.pagarFacturaSocio(socio, (numeroDeFactura-1));
						System.out.println("\n*********factura de socio pagada con éxito**********");
						break;
					}
					case 7: {
						ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
						ControladorFacturasInput facturasInput = new ControladorBussinessInputImp();
						ControladorAutorizadoBussiness autorizadoBussiness = new ControladorBussinessImp();
						ControladorFacturasBussiness facturasBussiness = new ControladorBussinessImp();
						ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
						ControladorClubBussiness clubBussiness = new ControladorBussinessImp();
						
						System.out.println("\n*********Registrar consumo a autorizado*********");
						System.out.println("Ingrese la cedula del autorizado que quiere registrar un consumo: ");
						Autorizado autorizado = personasBussiness.buscarAutorizado(gocClub.getSocios(), personasInput.validarCedula(input.next()));
						facturasBussiness.validarNumeroDeFacturas(autorizado.getFacturas());
						
						System.out.println("Ingrese el concepto consumo (nombre de lo que consumio): ");
						String conceptoConsumo = facturasInput.validarConceptoConsumo(input.next());
						
						System.out.println("Ingrese el valor de lo que consumio: ");
						double valor = facturasInput.validarValor(input.next());
						Socio socio = autorizadoBussiness.buscarSocioDeAutorizado(gocClub.getSocios(), autorizado.getCedula());
						clubBussiness.validarFondosSuficientes(valor, socio.getFondos());
						
						Factura factura = new Factura(autorizado.getNombre(), conceptoConsumo, valor);
						autorizado.setFactura(factura);
						
						System.out.println("\n*********Se registro el consumo con éxito*******");
						break;
					}
					case 8: {
						ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
						ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
						ControladorFacturasBussiness facturaBussiness = new ControladorBussinessImp();
						ControladorAutorizadoBussiness autorizadoBussiness = new ControladorBussinessImp();
						
						System.out.println("\n***************Pagar factura de autorizado***************");
						System.out.println("Ingrese la cedula del autorizado al que se le pagará una factura: ");
						Autorizado autorizado = personasBussiness.buscarAutorizado(gocClub.getSocios(), personasInput.validarCedula(input.next()));
						Socio socio = autorizadoBussiness.buscarSocioDeAutorizado(gocClub.getSocios(), autorizado.getCedula());
						System.out.println("Ingrese la cedula del socio que desea pagar una factura de un autorizado: ");
						int cedula = personasInput.validarCedula(input.next());
						facturaBussiness.validarFacturasPendientes(autorizado.getFacturas());						
						System.out.println("\n____________Facturas pendientes_____________");
						System.out.println(autorizado.mostrarFacturas());
						System.out.println("Ingrese el número de la factura que desea pagar: ");
						int numeroDeFactura = controladorInput.integerValido(input.next(), "El nùmero que ingreso");
						facturaBussiness.pagarFacturaAutorizado(socio, autorizado, cedula, (numeroDeFactura-1));
						System.out.println("\n*********factura de autorizado pagada con éxito**********");
						break;
					}
					case 9: {
						ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
						ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
						ControladorClubBussiness clubBussiness = new ControladorBussinessImp();
	
						System.out.println("\n***************Aumentar fondos a un socio***************");
						System.out.println("Ingrese el número de cedula del socio que quiere aumentar fondos: ");
						Socio socio = personasBussiness.buscarSocio(gocClub.getSocios(), personasInput.validarCedula(input.next()));
						
						System.out.println("Ingrese los fondos que desea añadir:");
						double fondos = personasInput.validarFondos(input.next());
						
						clubBussiness.validarTopeMaximo(socio.getTipoDeSuscripcion(), fondos + socio.getFondos());
						
						socio.setFondos(fondos + socio.getFondos());
						
						System.out.println("\n************Se aumentaron los fondos con éxito**********");
						break;
					}						
					case 10:{
						String menuMuestraDeDatos = "\n             GocClub                "
												  + "\n_____Menú de muestra de datos_____"
												  + "\nIngrese el nùmero que corresponda a la acción"
												  + "\nque requiera:"
												  + "\n1. Mostrar un socio"
												  + "\n2. Mostrar un socio y sus autorizados"
												  + "\n3. Mostrar un socio y sus facturas"
												  + "\n4. Mostrar un socio, sus autorizados y sus facturas"
												  + "\n5. Mostrar un autorizado"
												  + "\n6. Mostrar un autorizado y sus facturas"
												  + "\n7. Mostrar todos los socios"
												  + "\n8. Mostrar todos los socios y sus autorizados"
												  + "\n9. Mostrar todo lo almacenado"
												  + "\n0. Salir del menú de muestra de datos";
						boolean ejecucion2 = true;
						
						while(ejecucion2) {
							
							System.out.println(menuMuestraDeDatos);
							int opcion2 = controladorInput.integerValido(input.next(), "La opción que ingreso");
							
							switch(opcion2) {
								case 0: {
									System.out.println("Usted ha elegido salir del menú de muestra de datos ");
									ejecucion2 = false;
									break;
								}
								case 1: {
									ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
									ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
									
									System.out.println("\n***************Mostrar un socio***************");
									System.out.println("Ingrese el número de cedula del socio que quiere mostrar");
									Socio socio = personasBussiness.buscarSocio(gocClub.getSocios(), personasInput.validarCedula(input.next()));
									System.out.println("Mostrando socio:");
									System.out.println("______________________________");
									System.out.println(socio.mostrarDatos());
									System.out.println("______________________________");
									break;
								}
								case 2: {
									ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
									ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
									
									System.out.println("\n***************Mostrar un socio y sus autorizados***************");
									System.out.println("Ingrese el número de cedula del socio que quiere mostrar");
									Socio socio = personasBussiness.buscarSocio(gocClub.getSocios(), personasInput.validarCedula(input.next()));
									System.out.println("Mostrando socio y sus autorizados:");
									System.out.println("______________________________");
									System.out.println(socio.mostrarDatos());
									System.out.println(socio.mostrarautorizados());
									System.out.println("______________________________");
									break;
								}
								case 3: {
									ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
									ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
									
									System.out.println("\n***************Mostrar un socio y sus facturas***************");
									System.out.println("Ingrese el número de cedula del socio que quiere mostrar");
									Socio socio = personasBussiness.buscarSocio(gocClub.getSocios(), personasInput.validarCedula(input.next()));
									System.out.println("Mostrando socio y sus facturas:");
									System.out.println("______________________________");
									System.out.println(socio.mostrarDatos());
									System.out.println(socio.mostrarFacturas());
									System.out.println("______________________________");
									break;
								}
								case 4: {
									ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
									ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
									
									System.out.println("\n***************Mostrar un socio, sus autorizados y sus facturas***************");
									System.out.println("Ingrese el número de cedula del socio que quiere mostrar");
									Socio socio = personasBussiness.buscarSocio(gocClub.getSocios(), personasInput.validarCedula(input.next()));
									System.out.println("Mostrando socio, sus autorizados y sus facturas:");
									System.out.println("______________________________");
									System.out.println(socio.mostrarDatos());
									System.out.println(socio.mostrarFacturas());
									System.out.println(socio.mostrarautorizadosConFacturas());
									System.out.println("______________________________");
									break;
								}
								case 5: {
									ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
									ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
									
									System.out.println("\n***************Mostrar un autorizado***************");
									System.out.println("Ingrese el número de cedula del autorizado que quiere mostrar");
									Autorizado autorizado = personasBussiness.buscarAutorizado(gocClub.getSocios(), personasInput.validarCedula(input.next()));
									System.out.println("Mostrando autorizado:");
									System.out.println("______________________________");
									System.out.println(autorizado.mostrarDatos());
									System.out.println("______________________________");
									break;
								}
								case 6: {
									ControladorPersonasBussiness personasBussiness = new ControladorBussinessImp();
									ControladorPersonasInput personasInput = new ControladorBussinessInputImp();
									
									System.out.println("\n***************Mostrar un autorizado y sus facturas***************");
									System.out.println("Ingrese el número de cedula del autorizado que quiere mostrar");
									Autorizado autorizado = personasBussiness.buscarAutorizado(gocClub.getSocios(), personasInput.validarCedula(input.next()));
									System.out.println("Mostrando autorizado y sus facturas:");
									System.out.println("______________________________");
									System.out.println(autorizado.mostrarDatos());
									System.out.println(autorizado.mostrarFacturas());
									System.out.println("______________________________");
									break;
								}
								case 7: {
									System.out.println("\n***************Mostrar todos los socios***************");
									System.out.println("Mostrando todos los socios:");
									System.out.println("______________________________");
									System.out.println(gocClub.mostrarSocios());
									System.out.println("______________________________");
									break;
								}
								case 8: {
									System.out.println("\n***************Mostrar todos los socios y sus autorizados***************");
									System.out.println("Mostrando todos los socios y sus autorizados:");
									System.out.println("______________________________");
									System.out.println(gocClub.mostrarSociosConAutorizados());
									System.out.println("______________________________");
									break;
								}
								case 9: {
									System.out.println("\n***************Mostrar Todo***************");
									System.out.println("Mostrando Todo:");
									System.out.println("______________________________");
									System.out.println(gocClub.mostrarTodo());
									System.out.println("______________________________");
									break;
								}
								default: {
									System.out.println("La opción ingresada no es valida.");
									break;
								}
							}	

						}
						
						break;
					}
					default: {
						System.out.println("La opción ingresada no es valida.");
						break;
					}
					
				}	
				
			}catch(Exception e) {
				System.out.println(e.getMessage());	
			}

		}

	}

}

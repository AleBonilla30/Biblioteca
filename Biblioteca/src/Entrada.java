import controller.Biblioteca;
import model.*;
import utils.TipoHumor;
import utils.Trama;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args)  {

    Scanner scanner = new Scanner(System.in);
    Biblioteca<LibroTerror> biblioteca = new Biblioteca<>();
    Biblioteca<LibroComedia> biblioteca1 = new Biblioteca<>();
    Biblioteca<LibroPoliciaca> biblioteca2 = new Biblioteca<>();
    Biblioteca<Libro> biblioteca3 = new Biblioteca<>();
    System.out.println("◙ Creacion de Biblioteca ◙");
    System.out.println("▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪");
    int opcion;
    do {
        System.out.println();
        System.out.println(" ▪ Seleccione una opcion ▪");
        System.out.println("1. Crear una Biblioteca.");
        System.out.println("2. Crear catalogo de libros.");
        System.out.println("3. Agregar libros al catalogo.");
        System.out.println("4. Listar libros del catalogo.");
        System.out.println("5. Buscar un libro.");
        System.out.println("6. Eliminar un libro.");
        System.out.println("7. Exportar catálogo de libros.");
        System.out.println("8. Salir del programa");
        System.out.println("◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦");
        System.out.print("Ingrese un numero de la opción deseada: ");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦");
                System.out.println("Biblioteca especializada con libros de una temática");
                System.out.println("1. Biblioteca Libro Terror.");
                System.out.println("2. Biblioteca Libro Comedia.");
                System.out.println("3. Biblioteca Libro Policiaca.");
                System.out.println("4. Biblioteca Libros Mixtos.");
                System.out.print("Que opción eliges: ");
                int opcion1 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Introduce el nombre de la Biblioteca:");
                String nombre = scanner.nextLine();
                System.out.println("Introduce el nombre del Director:");
                String director = scanner.nextLine();
                switch (opcion1) {
                    case 1:
                        biblioteca = new Biblioteca<>(nombre, director);
                        biblioteca.mostrarDatosBiblioteca();
                        break;
                    case 2:
                        biblioteca1 = new Biblioteca<>(nombre, director);
                        biblioteca1.mostrarDatosBiblioteca();
                        break;
                    case 3:
                        biblioteca2 = new Biblioteca<>(nombre, director);
                        biblioteca2.mostrarDatosBiblioteca();
                        break;
                    case 4:
                        biblioteca3 = new Biblioteca<>(nombre, director);
                        biblioteca3.mostrarDatosBiblioteca();
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }

                break;
            case 2:
                System.out.println(" ▪ Creando catálogo ▪ ");
                System.out.println("1. Crear catálogo para Biblioteca Libro Terror.");
                System.out.println("2. Crear catálogo para Biblioteca Libro Comedia.");
                System.out.println("3. Crear catálogo para Biblioteca Libro Policiaca.");
                System.out.println("4. Crear catálogo para Biblioteca Libros Mixtos.");
                System.out.print("Que opción eliges: ");
                int opcionCatalogo = scanner.nextInt();
                System.out.print("Cuántos libros quieres ingresar en el catálogo: ");
                int catalogoLibro = scanner.nextInt();
                switch (opcionCatalogo) {
                    case 1:
                        System.out.println("◈ Catálogo biblioteca terror ◈");
                            biblioteca.construirCatalogoLibros(catalogoLibro);
                            biblioteca.consultarEspacio();
                            biblioteca.consultarNumeroLibros();

                        break;
                    case 2:
                        System.out.println("◈ Catálogo biblioteca comedia ◈");
                            biblioteca1.construirCatalogoLibros(catalogoLibro);
                            biblioteca1.consultarEspacio();
                            biblioteca1.consultarNumeroLibros();

                        break;
                    case 3:
                        System.out.println("◈ Catálogo biblioteca policiaca ◈");
                            biblioteca2.construirCatalogoLibros(catalogoLibro);
                            biblioteca2.consultarEspacio();
                            biblioteca2.consultarNumeroLibros();

                        break;
                    case 4:
                        System.out.println("◈ Catálogo biblioteca mixto ◈");
                            biblioteca3.construirCatalogoLibros(catalogoLibro);
                            biblioteca3.consultarEspacio();
                            biblioteca3.consultarNumeroLibros();
                        break;
                }
                break;
            case 3:


                    System.out.println("Añadiendo libros al catalogo");
                    System.out.println("1. Catálogo Libro terror.");
                    System.out.println("2. Catálogo Libro comedia.");
                    System.out.println("3. Catálogo Libro policiaca.");
                    System.out.println("4. Catálogo Libro mixto.");
                    System.out.print("Elige una opción: ");
                    int opcionAgregar = scanner.nextInt();
                    String autor ="";
                    int numPaginas = 0;
                    String isbn ="";

                    switch (opcionAgregar) {
                        case 1:
                            scanner.nextLine();
                            System.out.println("Introduce el Autor:");
                             autor= scanner.nextLine();
                            System.out.println("Introduce el numero de Paginas:");
                            numPaginas = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Introduce el ISBN:");
                            isbn = scanner.nextLine();
                            System.out.println("Introduce la clasificación: ");
                            int clasificacion = scanner.nextInt();
                            biblioteca.agregarLibrosCatalogo(new LibroTerror(autor, numPaginas, isbn, clasificacion));
                            break;
                        case 2:
                            scanner.nextLine();
                            System.out.println("Introduce el Autor:");
                            autor= scanner.nextLine();
                            System.out.println("Introduce el numero de Paginas:");
                            numPaginas = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Introduce el ISBN:");
                            isbn = scanner.nextLine();
                            System.out.println("Seleccione el tipo de humor:");
                            System.out.println("1. Negro.");
                            System.out.println("2. Sarcastico.");
                            System.out.println("3. Absurdo.");
                            System.out.println("4. Situacion.");
                            int opcionHumor = scanner.nextInt();
                            TipoHumor tipoHumorSeleccionado = switch (opcionHumor) {
                                case 1 -> TipoHumor.nego;
                                case 2 -> TipoHumor.sacastico;
                                case 3 -> TipoHumor.absurdo;
                                case 4 -> TipoHumor.situacion;
                                default -> null;
                            };

                            biblioteca1.agregarLibrosCatalogo(new LibroComedia(autor, numPaginas, isbn, tipoHumorSeleccionado));

                            break;
                        case 3:
                            scanner.nextLine();
                            System.out.println("Introduce el Autor:");
                            autor= scanner.nextLine();
                            System.out.println("Introduce el numero de Paginas:");
                            numPaginas = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Introduce el ISBN:");
                            isbn = scanner.nextLine();
                            System.out.println("Selecciones una Trama:");
                            System.out.println("1. MISTERIO");
                            System.out.println("2. INTRIGA");
                            int opcionTrama = scanner.nextInt();
                            Trama tramaSeleccionada = switch (opcionTrama) {
                                case 1 -> Trama.misterio;
                                case 2 -> Trama.intriga;
                                default -> null;
                            };
                            scanner.nextLine();
                            System.out.println("Introduce el personaje principal:");
                            String personaje = scanner.nextLine();
                            biblioteca2.agregarLibrosCatalogo(new LibroPoliciaca(autor, numPaginas, isbn, tramaSeleccionada,personaje ));

                            break;
                        case 4:
                            System.out.println();
                            System.out.println("◈ Has elegido el catalogo mixto ◈");
                            System.out.println("1. Agrega libro terror.");
                            System.out.println("2. Agrega libro comedia.");
                            System.out.println("3. Agrega libro policiaca.");
                            System.out.println("Cuál quieres agregar.");
                            int opcionMixto = scanner.nextInt();
                            switch (opcionMixto) {
                                case 1:
                                    scanner.nextLine();
                                    System.out.println("Introduce el Autor:");
                                    autor = scanner.nextLine();
                                    System.out.println("Introduce el numero de Paginas:");
                                    numPaginas = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Introduce el ISBN:");
                                    isbn= scanner.nextLine();
                                    System.out.println("Introduce clasificacion:");
                                    int clasificacion1 = scanner.nextInt();

                                    biblioteca3.agregarLibrosCatalogo(new LibroTerror(autor, numPaginas, isbn, clasificacion1));
                                    break;
                                case 2:
                                    scanner.nextLine();
                                    System.out.println("Introduce el Autor:");
                                    autor= scanner.nextLine();
                                    System.out.println("Introduce el numero de Paginas:");
                                    numPaginas = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Introduce el ISBN:");
                                    isbn = scanner.nextLine();
                                    System.out.println("Introduce el tipo de humor:");
                                    System.out.println("Seleccione el tipo de humor:");
                                    System.out.println("1. Negro.");
                                    System.out.println("2. Sarcastico.");
                                    System.out.println("3. Absurdo.");
                                    System.out.println("4. Situacion.");
                                    int opcionHumor1 = scanner.nextInt();
                                    TipoHumor tipoHumorSeleccionado1 = switch (opcionHumor1) {
                                        case 1 -> TipoHumor.nego;
                                        case 2 -> TipoHumor.sacastico;
                                        case 3 -> TipoHumor.absurdo;
                                        case 4 -> TipoHumor.situacion;
                                        default -> null;
                                    };

                                    biblioteca3.agregarLibrosCatalogo(new LibroComedia(autor, numPaginas, isbn, tipoHumorSeleccionado1));
                                    break;
                                case 3:
                                    scanner.nextLine();
                                    System.out.println("Introduce el Autor:");
                                    autor= scanner.nextLine();
                                    System.out.println("Introduce el numero de Paginas:");
                                    numPaginas = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Introduce el ISBN:");
                                    isbn = scanner.nextLine();
                                    System.out.println("Selecciones una Trama:");
                                    System.out.println("1. MISTERIO");
                                    System.out.println("2. INTRIGA");
                                    int opcionTrama1 = scanner.nextInt();
                                    Trama tramaSeleccionada1 = switch (opcionTrama1) {
                                        case 1 -> Trama.misterio;
                                        case 2 -> Trama.intriga;
                                        default -> null;
                                    };
                                    scanner.nextLine();
                                    System.out.println("Introduce el personaje principal:");
                                    String personaje1 = scanner.nextLine();
                                    biblioteca3.agregarLibrosCatalogo(new LibroPoliciaca(autor, numPaginas, isbn, tramaSeleccionada1, personaje1));
                                    biblioteca3.consultarNumeroLibros();
                                    break;
                            }
                            break;
                    }
                break;
            case 4:
                System.out.println("◈ Lista de libros en el catálogo ◈");
                System.out.println("1. Lista terror.");
                System.out.println("2. Lista comedia.");
                System.out.println("3. Lista policiaca.");
                System.out.println("4. Lista mixta.");
                System.out.print("Elije una opción: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        biblioteca.mostrarDatosBiblioteca();
                        biblioteca.consultarNumeroLibros();
                        biblioteca.listarLibrosCatalogo();
                        break;
                    case 2:
                        biblioteca1.mostrarDatosBiblioteca();
                        biblioteca1.consultarNumeroLibros();
                        biblioteca1.listarLibrosCatalogo();
                        break;
                    case 3:
                        biblioteca2.mostrarDatosBiblioteca();
                        biblioteca2.consultarNumeroLibros();
                        biblioteca2.listarLibrosCatalogo();
                        break;
                    case 4:
                        biblioteca3.mostrarDatosBiblioteca();
                        biblioteca3.consultarNumeroLibros();
                        biblioteca3.listarLibrosCatalogo();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                break;
            case 5:
                System.out.println("◈ Buscar libros en el catálogo ◈");
                System.out.println("1. Libro terror.");
                System.out.println("2. Libro comedia.");
                System.out.println("3. Libro policiaca.");
                System.out.println("4. Libro mixto.");
                System.out.print("Elije una opción: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        biblioteca.buscarLibro();
                        break;
                    case 2:
                        biblioteca1.buscarLibro();
                        break;
                    case 3:
                        biblioteca2.buscarLibro();
                        break;
                    case 4:
                        biblioteca3.buscarLibro();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }

                break;
            case 6:
                System.out.println();
                System.out.println("◈ Eliminar libros de el catálogo ◈");
                System.out.println("1. Libro terror.");
                System.out.println("2. Libro comedia.");
                System.out.println("3. Libro policiaca.");
                System.out.println("4. Libro mixto.");
                System.out.print("Elije una opción: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        biblioteca.sacarLibros();
                        break;
                    case 2:
                        biblioteca1.sacarLibros();
                        break;
                    case 3:
                        biblioteca2.sacarLibros();
                        break;
                    case 4:
                        biblioteca3.sacarLibros();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }

                break;
            case 7:
                System.out.println("◈ Exportar catálogo de libros ◈");
                System.out.println("Seleccione la biblioteca:");
                System.out.println("1. Biblioteca de Terror");
                System.out.println("2. Biblioteca de Comedia");
                System.out.println("3. Biblioteca de Policiaca");
                System.out.println("4. Biblioteca Mixta");
                int opcionBiblioteca = scanner.nextInt();
                Biblioteca bibliotecaSeleccionada = null;
                switch (opcionBiblioteca) {
                    case 1:
                        bibliotecaSeleccionada = biblioteca;
                        
                        break;
                    case 2:
                        bibliotecaSeleccionada = biblioteca1;

                        break;
                    case 3:
                        bibliotecaSeleccionada = biblioteca2;

                        break;
                    case 4:
                        bibliotecaSeleccionada = biblioteca3;

                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                if (bibliotecaSeleccionada != null) {

                     bibliotecaSeleccionada.ficheroExportar();
                }

                break;
            case 8:
                System.out.println(" ◾Programa finalizado◾ ");
                break;
        }
        System.out.println("Presiones Si para continuar ↪️");
        scanner.next();

    } while (opcion != 8);
    scanner.close();
    }
}

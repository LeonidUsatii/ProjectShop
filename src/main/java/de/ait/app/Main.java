package de.ait.app;
import de.ait.models.*;
import de.ait.repositories.books.BooksRepository;
import de.ait.repositories.books.BooksRepositoryTextFileImpl;
import de.ait.repositories.films.FilmsRepository;
import de.ait.repositories.films.FilmsRepositoryTextFileImpl;
import de.ait.repositories.musics.MusicsRepository;
import de.ait.repositories.musics.MusicsRepositoryTextFileImpl;
import de.ait.repositories.products.ProductsRepository;
import de.ait.repositories.products.ProductsRepositoryTextFileImpl;
import de.ait.repositories.users.UsersRepository;
import de.ait.repositories.users.UsersRepositoryTextFileImpl;
import de.ait.services.BookService.BookService;
import de.ait.services.BookService.BookServiceImpl;
import de.ait.services.FilmService.FilmService;
import de.ait.services.FilmService.FilmServiceImpl;
import de.ait.services.MusicService.MusicService;
import de.ait.services.MusicService.MusicServiceImpl;
import de.ait.services.ProductService.ProductService;
import de.ait.services.ProductService.ProductServiceImpl;
import de.ait.services.UserService.UserService;
import de.ait.services.UserService.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("files/users.txt");
        UserService userService = new UserServiceImpl(usersRepository);

        ProductsRepository productsRepository = new ProductsRepositoryTextFileImpl("files/products.txt");
        ProductService productService = new ProductServiceImpl(productsRepository);

        BooksRepository booksRepository = new BooksRepositoryTextFileImpl("files/books.txt");
        BookService bookService = new BookServiceImpl(booksRepository, productsRepository);

        MusicsRepository  musicsRepository = new MusicsRepositoryTextFileImpl("files/musics.txt");
        MusicService musicService = new MusicServiceImpl(musicsRepository, productsRepository);

        FilmsRepository filmsRepository = new FilmsRepositoryTextFileImpl("files/films.txt");
        FilmService filmService = new FilmServiceImpl(filmsRepository, productsRepository);

        while (true) {
            System.out.println();
            System.out.println("Приветствуем в нашем магазине, для совершения покупок, " +
                    "нужно авторизоваться.");
            System.out.println();
            System.out.println("1. Создать личный кабинет:");
            System.out.println("2. Просмотреть продукцию");
            System.out.println("3. Добавить новый товар");
            System.out.println("0. Выход");
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    System.out.println("Авторизоваться:");

                    System.out.println("Введите имя: ");
                    String firstName = scanner.nextLine();

                    System.out.println("Введите фамилию: ");
                    String lastName = scanner.nextLine();

                    System.out.println("Введите email: ");
                    String email = scanner.nextLine();

                    System.out.println("Введите пароль: ");
                    String password = scanner.nextLine();

                    userService.addUser(firstName, lastName, email, password);

                    break;

                case 2:
                    System.out.println("1. Просмотреть всю продукцию");
                    System.out.println("2. Просмотреть книги");
                    System.out.println("3. Просмотреть музыкальную продукцию");
                    System.out.println("4. Просмотреть фильмы");

                    command = scanner.nextInt();
                    scanner.nextLine();

                    switch (command) {
                        case 1:
                            List<Product> products = productService.getProducts();
                            System.out.println(products);
                            break;
                        case 2:
                            List<Book> books = bookService.getProducts();
                            System.out.println(books);
                            break;
                        case 3:
                            List<Music> music = musicService.getProducts();
                            System.out.println(music);
                            break;
                        case 4:
                            List<Film> films = filmService.getProducts();
                            System.out.println(films);
                            break;

                    }

                    System.out.println();
                    break;
                case 3:
                   System.out.println("Добавляем новый товар");

                    System.out.println("Выберите категорию товара: ");

                    System.out.println("1. Книга");
                    System.out.println("2. Музыка");
                    System.out.println("3. Фильм");

                    command = scanner.nextInt();
                    scanner.nextLine();

                    Category category = null;

                    switch (command) {
                        case 1:
                            category = Category.BOOK;
                            break;
                        case 2:
                            category = Category.MUSIC;
                            break;
                        case 3:
                            category = Category.FILM;
                            break;
                    }

                    System.out.println("Введите название: ");
                    String title = scanner.nextLine();

                    System.out.println("Введите стоимость: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Введите дату выпуска: ");
                    String releaseYear = scanner.nextLine();

                    if (category == Category.BOOK) {
                        System.out.println("Введите автора: ");
                        String author = scanner.nextLine();

                        System.out.println("Введите жанр книги: ");

                        System.out.println("1. Детектив");
                        System.out.println("2. Новелла");
                        System.out.println("3. Поэзия");
                        System.out.println("4. Фантастика");
                        System.out.println("5. Обучение");
                        System.out.println("6. Детская литература");

                        command = scanner.nextInt();
                        scanner.nextLine();
                        GenreOfBook genreOfBook = null;

                        switch (command) {
                            case 1:
                                genreOfBook = GenreOfBook.DETECTIVE;
                                break;
                            case 2:
                                genreOfBook = GenreOfBook.NOVEL;
                                break;
                            case 3:
                                genreOfBook = GenreOfBook.POETRY;
                                break;
                            case 4:
                                genreOfBook = GenreOfBook.FANTASY;
                                break;
                            case 5:
                                genreOfBook = GenreOfBook.EDUCATION;
                                break;
                            case 6:
                                genreOfBook = GenreOfBook.KIDS;
                                break;
                        }
                        bookService.addBook(category, title,  price, releaseYear, author,
                                 genreOfBook);

                    } else if (category == Category.MUSIC) {
                        System.out.println("Введите жанр музыки: ");

                        System.out.println("1. Рок");
                        System.out.println("2. Поп");
                        System.out.println("3. Классика");
                        System.out.println("4. Этническая");

                        command = scanner.nextInt();
                        scanner.nextLine();
                        GenreOfMusic genreOfMusic = null;

                        switch (command) {
                            case 1:
                                genreOfMusic = GenreOfMusic.ROCK;
                                break;
                            case 2:
                                genreOfMusic = GenreOfMusic.POP;
                                break;
                            case 3:
                                genreOfMusic = GenreOfMusic.CLASSIC;
                                break;
                            case 4:
                                genreOfMusic = GenreOfMusic.ETHNIC;
                                break;
                        }
                        System.out.println("Введите исполнителя: ");
                        String executor = scanner.nextLine();

                        musicService.addMusic(category, title, price, releaseYear,
                                genreOfMusic, executor);

                    } else if (category == Category.FILM) {
                        System.out.println("Введите жанр фильма: ");

                        System.out.println("1. Комедия");
                        System.out.println("2. Фантастика");
                        System.out.println("3. Боевик");
                        System.out.println("4. Триллер");

                        command = scanner.nextInt();
                        scanner.nextLine();
                        GenreOfFilm genreOfFilm = null;

                        switch (command) {
                            case 1:
                                genreOfFilm = GenreOfFilm.COMEDY;
                                break;
                            case 2:
                                genreOfFilm = GenreOfFilm.FANTASTIC;
                                break;
                            case 3:
                                genreOfFilm = GenreOfFilm.ACTION;
                                break;
                            case 4:
                                genreOfFilm = GenreOfFilm.THRILLER;
                                break;
                        }
                        filmService.addFilm(category, title,  price, releaseYear, genreOfFilm);
                    }
                    break;
                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана");
            }
        }
    }
}

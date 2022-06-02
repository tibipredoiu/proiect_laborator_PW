package com.example.proiectfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MoviesRepository moviesRepository;

        @GetMapping("")
        public String HomePage()
        {
            return "homePage.html";
        }

        @GetMapping("/register")
        public String SignUpForm(Model model)
        {
            model.addAttribute("user", new UserClass());
            return "signUp.html";
        }

        @PostMapping("/process_register")
        public String processRegistration(UserClass userClass)
        {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(userClass.getPassword());
            userClass.setPassword(encodedPassword);
            userRepository.save(userClass);
            return "registrationSucces.html";
        }

        @GetMapping("/movies_list")
        public String WatchMovie(Model model)
        {
            model.addAttribute("MoviesList", moviesRepository.findAll());
            return "moviesList.html";
        }

        @PostMapping("/add_movie")
        public String AddMovie(MoviesClass moviesClass)
        {
            moviesRepository.save(moviesClass);
            return "MovieAddSucces.html";
        }

        @GetMapping("edit_delete_movie")
        public String UpdateMoviePage()
        {
            return "updateDelete.html";
        }

       @PostMapping("/edit_movie")
       public String UpdateMovie(MoviesClass moviesClass)
       {
            MoviesClass updatedData = moviesRepository.findByMovieId(moviesClass.getMovieId());
            updatedData.setMovieName(moviesClass.getMovieName());
            updatedData.setReleaseDate(moviesClass.getReleaseDate());
            updatedData.setRating(moviesClass.getRating());

            moviesRepository.save(updatedData);
            return "MovieAddSucces.html";
       }

       @PostMapping("/delete_movie")
       public String DeleteMovie(@RequestParam("MovieId") Long id)
       {
           moviesRepository.deleteById(id);
           return "MovieAddSucces.html";
       }

}

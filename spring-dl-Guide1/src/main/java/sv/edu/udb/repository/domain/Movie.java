package sv.edu.udb.repository.domain;

/*
Cambio usando "Persistance" por springboot 4
y el uso de las anotaciones Lombok como (@Builder)
 */

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private Integer releaseYear;
}
package pl.wsb.fitnesstracker.healthmetrics;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;




@Entity
@Table(name = "Health_Metrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok: "Zrób pusty konstruktor dla bazy"
@ToString // Lombok: "Zrób metodę do ładnego wyświetlania tekstu"
public class HealthMetrics {

    @Id // To jest nasz główny klucz (ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Baza sama nadaje numery: 1, 2, 3...
    @Nullable
    private Long id;

    // RELACJA W JPA:
    // Na schemacie idzie kreska od Users do Health_Metrics.
    // To relacja Wiele-do-Jednego (@ManyToOne), bo jeden użytkownik (User)
    // może mieć wiele wpisów z pomiarami zdrowia.


    @Column(name = "date", nullable = false) // nullable = false oznacza, że to pole nie może być puste
    private LocalDate date;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @Column(name = "heartRate")
    private Integer heartRate;


}
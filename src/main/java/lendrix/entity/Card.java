package lendrix.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cardid;

    @Column(unique = true, nullable = false, length = 16)
    private String cardnumber;

    private String cardholder;

    private double balance;

    @CreationTimestamp
    @Column(updatable=false)
    private LocalDateTime createdAt;
    

    private String iss;  // Issuer (e.g., "VISA", "MasterCard")
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDate exp;  // Expiry date

    @Column(length = 4)
    private String cvv;

    private String pin;

    private String billing;  // Billing address or billing profile info


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions; 

}



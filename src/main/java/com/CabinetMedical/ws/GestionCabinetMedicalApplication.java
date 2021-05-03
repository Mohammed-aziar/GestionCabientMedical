package com.CabinetMedical.ws;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//hi this test for ssh
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.CabinetMedical.ws.entities.CertificatEntity;
import com.CabinetMedical.ws.entities.PatientEntity;
import com.CabinetMedical.ws.entities.PayementEntity;
import com.CabinetMedical.ws.entities.PreInformationEtatEntity;
import com.CabinetMedical.ws.entities.RDVEntity;
import com.CabinetMedical.ws.entities.VisiteEntity;
import com.CabinetMedical.ws.repositories.CertificatRepository;
import com.CabinetMedical.ws.repositories.PatientRepository;
import com.CabinetMedical.ws.repositories.PayementRepository;
import com.CabinetMedical.ws.repositories.PreInformationEtatRepository;
import com.CabinetMedical.ws.repositories.RDVRepository;
import com.CabinetMedical.ws.repositories.VisiteRepository;

@SpringBootApplication
public class GestionCabinetMedicalApplication implements CommandLineRunner {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	RDVRepository rdvRepository;

	@Autowired
	PreInformationEtatRepository etatRepository;

	@Autowired
	VisiteRepository visiteRepository;

	@Autowired
	PayementRepository payementRepository;
	
	@Autowired
	CertificatRepository certificatRepository;
	public static void main(String[] args) {
		SpringApplication.run(GestionCabinetMedicalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<RDVEntity> rdvs = new ArrayList<>();
		List<CertificatEntity> crt = new ArrayList<>();
		
		PatientEntity patient = new PatientEntity("aziar", "mohammed", "mers elkhier s2 N 357", "+212665494397",
				"mohammed.aziar@gmail.com", "homme", "AD298721", "etudant", "+AB", LocalDate.of(1999, 1, 9),
				new Date());

		patientRepository.save(patient);
		RDVEntity rdv = new RDVEntity(LocalDateTime.of(2021, Month.APRIL, 25, 12, 10, 1), new Date(), patient);
		RDVEntity rdv2 = new RDVEntity(LocalDateTime.of(2021, Month.MAY, 5, 13, 0, 1), new Date(), patient);
		rdvs.add(rdv);
		rdvs.add(rdv2);

		PreInformationEtatEntity informationEtatEntity = new PreInformationEtatEntity("hello", patient);

		rdvRepository.saveAll(rdvs);
		etatRepository.save(informationEtatEntity);

		VisiteEntity visite = new VisiteEntity(new Date(), new Date(), "test motif", "test type", "test diagnostic",
				"test commantaire", patient);
		VisiteEntity visite2 = new VisiteEntity(new Date(), new Date(), "test motif", "test type", "test diagnostic",
				"test commantaire", patient);
		PayementEntity payementEntity = new PayementEntity(1234, true, visite);
		PayementEntity payementEntity2 = new PayementEntity(122, false, visite2);
		visiteRepository.save(visite);
		visiteRepository.save(visite2);
		
		CertificatEntity certificatEntity=new CertificatEntity( 4, "beghit ", visite);
		CertificatEntity certificatEntity2=new CertificatEntity( 5, "beghit ", visite);
		
		crt.add(certificatEntity);
		crt.add(certificatEntity2);
		
		payementRepository.save(payementEntity);
		payementRepository.save(payementEntity2);
		certificatRepository.saveAll(crt);
		
		/*
		 * System.out.println("****************************");
		 * patientRepository.findAll().forEach(p -> { System.out.println(p.toString());
		 * }); System.out.println("****************************");
		 * rdvRepository.findAll().forEach(r -> { System.out.println(r.toString()); });
		 * 
		 * System.out.println("************************************");
		 * etatRepository.findAll().forEach(r -> { System.out.println(r.toString()); });
		 */
	}
	
	
//	@Bean
//	public PasswordEncoder encoder() {
//	    return new BCryptPasswordEncoder();
//	}
//	

}

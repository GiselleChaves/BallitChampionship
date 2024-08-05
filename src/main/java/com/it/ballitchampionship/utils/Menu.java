//package com.it.ballitchampionship.utils;
//
//import com.it.ballitchampionship.controller.TeamController;
//import com.it.ballitchampionship.entity.TeamEntity;
//import com.it.ballitchampionship.entity.dtos.TeamDto;
//import com.it.ballitchampionship.service.TeamService;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Scanner;
//@AllArgsConstructor
//public class Menu {
//    Scanner in = new Scanner(System.in);
//    //private final TeamController teamController;
//    private  final TeamService teamService;
//
//    public Menu(TeamController teamController) {
//        this.teamController = teamController;
//    }
//
//    public void run() {
//
//        int option;
//        do {
//            option = chooseOption();
//            switch (option) {
//                case 1: //REGISTERING NEW TEAM
//                    //teamService.save(TeamDto teamDto);
//                    break;
//
//                case 0: //FINISH PROGRAM
//                    System.out.println("Finish");
//
//                default:
//                    System.out.println("Invalid input.");
//            }
//        } while (option != 0);
//
//
//    }
//
//    public int chooseOption() {
//
//        System.out.println(" ----------------------------------------");
//        System.out.println("|   WELCOME TO THE BALLIT CHAMPIONSHIP!  |");
//        System.out.println(" ----------------------------------------\n");
//
//        System.out.println("..:::Below choose one option:::..\n");
//        System.out.println("1 - Register Team");
//        System.out.println("2 - Start Championship");
//        System.out.print("Digit the option: ");
//
//        return Integer.parseInt(in.nextLine());
//    }
//
//    public void registerTeam() {
//
//        System.out.println("\n| Register Team |");
//        System.out.println("-------------");
//
//        System.out.print("Inform the Team Name:");
//        String name = in.nextLine();
//
//        TeamEntity teamEntity = teamService.getByName(name);
//
//        if(punterEntity == null){
//            System.out.print("Inform your name:");
//            String name = in.nextLine();
//
//            punterEntity = PunterEntity.builder()
//                    .name(name)
//                    .document(document)
//                    .build();
//            punterService.save(punterEntity);
//            System.out.println("________________________________________");
//            System.out.println("New user created!");
//            System.out.println("Name: " + punterEntity.getName());
//            System.out.println("Document: " + punterEntity.getDocument());
//            System.out.println("________________________________________");
//        }
//}

package com.example.selfquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionsBank extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(QuestionsBank.this, QuizActivity.class));
    }



    private static List<QuestionsList> javaQuestions(){
        final List<QuestionsList> questionsList = new ArrayList<>();
        List<QuestionsList> randomQuestionList = new ArrayList<>();
        //create questions
        final QuestionsList question1 = new QuestionsList("What is the size of an int variable?", "16 bit", "8 bit", "32 bit", "64 bit", "32 bit", "");
        final QuestionsList question2 = new QuestionsList("Which of the following is not a Java features?", "Dynamic", "Architecture Neutral", "Use of Pointers", "Object-oriented", "Use of Pointers", "");
        final QuestionsList question3 = new QuestionsList("The u0021 article referred to as a", "Unicode escape sequence", "Octal escape", "Hexadecimal", "Line feed", "Unicode escape sequence", "");
        final QuestionsList question4 = new QuestionsList("___ is used to find and fix bugs in the java programs","JVM","JRE","JDK","JDB","JDB","");
        final QuestionsList question5 = new QuestionsList("What is the return type of hashCode() method in the Object Class","Object","int","long","void","int","");
        final QuestionsList question6 = new QuestionsList("Which of the following is a valid long literal?","ABH8097","L990023","904423","0xnf029L","0xnf029L","");
        final QuestionsList question7 = new QuestionsList("What does the expression float a = 34/0 return?","0","Not a number","Infinity","Run-Time Exception","Infinity","");
        final QuestionsList question8 = new QuestionsList("Evaluate the following java expression, if x=3, y=5, and z=10: \n\t ++z+y-y+z+x++","23","24","20","25","25","");
        final QuestionsList question9 = new QuestionsList("Which of the following creates a List of 3 visible items and multiple selections abled?","new List(false, 3)","new List(3, true)","new List(true, 3","new List(3,false)","new List(3, true)","");
        final QuestionsList question10 = new QuestionsList("Which of the following for loop declaration is not valid?","for ( int i = 99; i >= 0; i / 9 )","for ( int i = 7; i <= 77; i += 7 )","for ( int i = 20; i >= 2; - -i )","for ( int i = 2; i <= 20; i = 2* i )","for ( int i = 99; i >= 0; i / 9 )","");
        final QuestionsList question11 = new QuestionsList("Which method of the Class.class is used to determine the name of a class represented by the class object as a String?","getClass()","intern()","getName()","toString()","getName()","");
        final QuestionsList question12 = new QuestionsList("In which process, a local variable has the same name as one of the instance variables?","Multi-threading","Abstraction","Variable Shadowing","Serialization","Variable Shadowing","");
        final QuestionsList question13 = new QuestionsList("Which of the following is true about the anonymous inner class?","It has only methods","Objects can't be created","It has a fixed class name","It has no class name","It has no class name","");
        final QuestionsList question14 = new QuestionsList("Which package contains the Random class?","java.util package","java.lang package","java.awt package","java.io package","java.util package","");
        final QuestionsList question15 = new QuestionsList("What do you mean by nameless objects?","An object created by using the new keyword.","An object of a superclass created in the subclass","An object without having any name but having a reference.","An object that has no reference","An object that has no reference","");
        final QuestionsList question16 = new QuestionsList("An interface with no fields or methods is known as a ______.","Runnable Interface","Marker Interface","Abstract Interface","CharSequence Interface","Marker Interface","");
        final QuestionsList question17 = new QuestionsList("Which of these classes are the direct subclasses of the Throwable class?","RunTimeException and Error class","Exception and VirtualMachineError class","Error and Exception Class","IOException and VirtualMachineError class","Error and Exception Class","");
        final QuestionsList question18 = new QuestionsList("Which option is false about the final keyword?","a final method cannot be overridden in its subclasses","a final class cannot be extended","a final class cannot extend other classes","a final class cannot be inherited","a final class cannot extend other classes","");
        final QuestionsList question19 = new QuestionsList("What will be the output of the following program?\n" +
                                                            "public class Test2 {  \n" +
                                                            "    public static void main(String[] args) {  \n" +
                                                            "        StringBuffer s1 = new StringBuffer(\"Complete\");  \n" +
                                                            "        s1.setCharAt(1,'i');  \n" +
                                                            "        s1.setCharAt(7,'d');  \n" +
                                                            "        System.out.println(s1);  \n" +
                                                            "     }  \n" +
                                                            " }","Complete","Iomplede","Cimpletd","Coipletd","Cimpletd","");
        final QuestionsList question20 = new QuestionsList("What will be the output of the following program?\n" +
                                                            "abstract class MyFirstClass  \n" +
                                                            "{  \n" +
                                                            "     abstract num (int a, int b) {  }  \n" +
                                                            "}  \n","No error","Method is not defined properly","Constructor is not defined properly","Extra parentheses","Method is not defined properly","");



        //add random questions to questionsLists
        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        questionsList.add(question11);
        questionsList.add(question12);
        questionsList.add(question13);
        questionsList.add(question14);
        questionsList.add(question15);
        questionsList.add(question16);
        questionsList.add(question17);
        questionsList.add(question18);
        questionsList.add(question19);
        questionsList.add(question20);

        for (int i=0;i<10;i++) {
            Random random = new Random();
            QuestionsList rando = questionsList.get(random.nextInt(20));
            randomQuestionList.add(rando);
        }
        return randomQuestionList;
    }

    private static List<QuestionsList> biologyQuestions(){
        final List<QuestionsList> questionsList = new ArrayList<>();
        List<QuestionsList> randomQuestionList = new ArrayList<>();
        Random random = new Random();

        final QuestionsList question1 = new QuestionsList("The adult human of average age and size has approximately how many quarts of blood?","4","6","8","10","6","");
        final QuestionsList question2 = new QuestionsList("Once the erythrocytes enter the blood in humans, it is estimated that they have an average lifetime of how many days.","10 days","120 days","200 days","360 days","120 days","");
        final QuestionsList question3 = new QuestionsList("Of the following, which mechanisms are important in the death of erythrocytes in human blood?","phagocytosis","hemolysis","mechanical damage","all of the above","all of the above","");
        final QuestionsList question4 = new QuestionsList("Surplus red blood cells, needed to meet an emergency, are MAINLY stored in what organ of the human body?","pancreas","spleen","liver","kidney","spleen","");
        final QuestionsList question5 = new QuestionsList("In most axons, the myelin sheath is interrupted at intervals of about 1 millimeter or more. These interruptions are called the:","glial","nodes of Ranvier","collaterals","nodes of Babinet","nodes of Ranvier","");
        final QuestionsList question6 = new QuestionsList("In cell division, the phase following the metaphase is known as:","prophase","anaphase","telophase","extophase","anaphase","");
        final QuestionsList question7 = new QuestionsList("Which type of muscle is a syncytium","skeletal","cardiac","smooth","all of the above","skeletal","");
        final QuestionsList question8 = new QuestionsList("When the potential difference across a membrane of a neuron equals the threshold, what results?","movement of the membrane","action potential","relaxation","contraction","action potential","");
        final QuestionsList question9 = new QuestionsList("What ions determine the resting potential of a nerve?","sodium and calcium","calcium and copper","potassium and calcium","sodium and potassium","sodium and potassium","");
        final QuestionsList question10 = new QuestionsList("Digestion of PROTEINS begins in which of the following human organs?","small intestines","colon","mouth","stomach","stomach","");
        final QuestionsList question11 = new QuestionsList("For which of the following creatures is fat the greatest percentage of body weight?","Termite","Blue Whale","Zebra","Female Lion","Blue Whale","");
        final QuestionsList question12 = new QuestionsList("Which is false regarding freshwater fish?","Their blood is hypertonic to their environment","They often actively take up salt","They excrete urine hypotonic to the blood","Their gills actively excrete salt","Their gills actively excrete sale","");
        final QuestionsList question13 = new QuestionsList("If a male who is heterozygous for an autosomal trait mates with a female who is also heterozygous for that trait, what percent of their offspring are likely to be heterozygous for this trait as well?","25%","50%","100%","75%","50%","");
        final QuestionsList question14 = new QuestionsList("Bile has what function in digestion?","Emulsify lipids","Digest proteins","Gluconeogenesis","Digest carbohydrates","Emulsify lipids","");
        final QuestionsList question15 = new QuestionsList("Select the hormone INCORRECTLY paired with it's target","TSH - thyroid gland","ACTH - anterior pituitary","LH - ovary or testis","MSH - melanocytes","MSH - melanocytes","");
        final QuestionsList question16 = new QuestionsList("Which is true? Costal cartilage","Attach the ribs to the sternum","Cover the ends of the femur"," Is found in the pinna of the ear","Forms the invertebral disks of the backbone","Attach the ribs to the sternum","");
        final QuestionsList question17 = new QuestionsList("During photosynthesis","light reactions produce sugar, while the Calvin cycle produces O2.","Light reactions produce NADPH and ATP, while the Calvin cycle produces sugar.","Light reactions photophosphorylate ADP, while the Calvin cycle produces ATP.","The Calvin cycle produces both sugar and O2.","Light reactions produce NADPH and ATP, while the Calvin cycle produces sugar.","");
        final QuestionsList question18 = new QuestionsList("Name the three main types of SVT","Atrial tachycardia, atrioventricular nodal reentrant tachycardia, atrioventricular reentrant tachycardia","WPW, AVNRT,AVRT","A-fib,Aflutter, V-tach","RBBB, Wenckebach, Morbitz","Atrial tachycardia, atrioventricular nodal reentrant tachycardia, atrioventricular reentrant tachycardia","");
        final QuestionsList question19 = new QuestionsList(" List three major coronary arteries","RCA, RCA marginal branch, and Left marginal branch","Aorta, Aortic Arch, and pulmonary arteries","LAD,LCX, and RCA","SA node, AV node, and Bundle of His","RCA, RCA marginal branch, and Left marginal branch","");
        final QuestionsList question20 = new QuestionsList("What SVT is associated with a Delta wave?","AVRT (WPW)","AVNRT","Atrial Tachycardia","V-Tach","AVRT (WPW)","");

        //add random questions to questionsLists
        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        questionsList.add(question11);
        questionsList.add(question12);
        questionsList.add(question13);
        questionsList.add(question14);
        questionsList.add(question15);
        questionsList.add(question16);
        questionsList.add(question17);
        questionsList.add(question18);
        questionsList.add(question19);
        questionsList.add(question20);

        for (int i=0;i<10;i++) {
            QuestionsList rando = questionsList.get(random.nextInt(20));
            randomQuestionList.add(rando);
        }
        return randomQuestionList;
    }

    private static List<QuestionsList> cardiologyQuestions() {
        final List<QuestionsList> questionsList = new ArrayList<>();
        List<QuestionsList> randomQuestionList = new ArrayList<>();
        Random random = new Random();

        final QuestionsList question1 = new QuestionsList("The apex of the heart is typically found on a line drawn vertically downward from the:","head of the humerus","junction of the clavicle and scapula","midpoint of the clavicle","junction of the clavicle and sternum","midpoint of the clavicle","");
        final QuestionsList question2 = new QuestionsList("The bundle of His is part of the:","endocardium","myocardium","epicardium","pericardium","myocardium","");
        final QuestionsList question3 = new QuestionsList("Muscular ridges prominent in the ventricles are called:","trabeulae carneae","pectinate muscles","crista terminalis","chordae tendineae","trabeulae carneae","");
        final QuestionsList question4 = new QuestionsList("The heart chamber whose myocardium consumes the most oxygen is the:","right atrium","left atrium","right ventricle","left ventricle","left ventricle","");
        final QuestionsList question5 = new QuestionsList("Which of the following structures would be located closest to the AV node?","SA node","membranous interventriular septum","Purkinje fibers","moderator band","membranous interventriular septum","");
        final QuestionsList question6 = new QuestionsList("Most of the volume of a typical myocyte is composed of the:","sarcolemma","sarcoplasmic reticulum","sarcoplasm","nucleus","sarcoplasm","");
        final QuestionsList question7 = new QuestionsList("An extra systolic heart sound heard just after S1 is referred to as:","summation gallop","ejection click","mid-late systolic click","opening snap","ejection click","");
        final QuestionsList question8 = new QuestionsList("Which of the following cardiac manifestations is Turner's syndrome associated with?","Aortic regurgitation and/or dissection","Atrial septal defect, ventricular septal defect","Coarctation of the aorta","Displaced tricuspid valve and atrial septal defect","Atrial septal defect, ventricular septal defect","");
        final QuestionsList question9 = new QuestionsList("Which of the following cardiac manifestations is Marfan's genetic disorder associated with? ","Aortic regurgitation and/or dissection","Atrial septal defect and ventricular septal defect","Coarctation of the aorta","Displaced tricuspid valve and atrial septal defect","Aortic regurgitation and/or dissection","");
        final QuestionsList question10 = new QuestionsList("What key pulmonary radiographic finding are associated with heart failure?","Cardiomegaly, Pulmonary Edema, Shunts","Cardiomegaly, Pulmonary Edema, Redistribution of blood flow from the lungs","Pulmonary Edema, Redistribution of blood flow from the lungs, Valvular lesions","Redistribution of blood flow from the lungs, Shunts, Valvular lesions","Cardiomegaly, Pulmonary Edema, Redistribution of blood flow from the lungs","");
        final QuestionsList question11 = new QuestionsList("What are some common fibrinolytic treatments used during an ST elevation MI?","Alteplase and Nitrates","Alteplase and Ramipril","Alteplase and Streptokinase","Alteplase and Zymed","Alteplase and Streptokinase","");
        final QuestionsList question12 = new QuestionsList("What is the most useful method used to diagnose myocardial ischemia?","Coronary Angiography","Electrocardiogram","Exercise stress test","Pharmacological stress testing","Exercise stress test","");
        final QuestionsList question13 = new QuestionsList("Oxygen is determined by ________ and _________.  ","Coronary perfusion pressure and hemoglobin concentration","Coronary vascular resistance and systemic concentration","External compression and intrinsic regulation","Hemoglobin concentration and systemic concentration","Hemoglobin concentration and systemic concentration","");
        final QuestionsList question14 = new QuestionsList("Sudden cardiac death is usually caused by:","Ventricular flutter","Ventricular fibrillation","Agonal rhythm","Sustained ventricular tachycardia","Sustained ventricular techycarida","");
        final QuestionsList question15 = new QuestionsList("Which of the following are drug therapies that have shown to reduce the rate of sudden cardiac death?","ACE Inhibitors, Beta Blockers, Sotalol","Beta Blockers, Nitrates, Sotalol","ACE Inhibitors, Beta Blockers, Nitrates","ACE Inhibitors, Sotalol, Nitrates","ACE Inhibitors, Beta Blockers, Sotalol","");
        final QuestionsList question16 = new QuestionsList("The risk factors for Sudden Cardiac Death, include: ","Alcohol, History of Myocardial Infarction, Obesity","Diabetes, History of Myocardial Infarction, Hypertension","Diabetes, Hypertension, Family History","Family History, Smoking, Obesity","Diabetes, Hypertension, Family History","");
        final QuestionsList question17 = new QuestionsList("What of the following is NOT a Non Ischemic Heart Disease associated with Sudden Cardiac Death?","Cardiomyopathies","Electrolyte abnormalities","Inflammatory heart disease","Small vessel disease","Small vessel disease","");
        final QuestionsList question18 = new QuestionsList("According to the Vaughan-Williams classification system, What class of anti-arrhythmic is Lidocaine?","1A","1B","1C","2","1B","");
        final QuestionsList question19 = new QuestionsList("What is the main contraindication for the use of verapamil and diltiazem?","Atrial arrythmias","Reentry tachyarrythmias","Supraventricular tachyarrythmias","Ventricular tachycardias","Reentry tachyarrythmias","");
        final QuestionsList question20 = new QuestionsList("While controlling chest pain, nitroglycerin also causes:","Decreased blood pressure","Decreased heart rate","Increased haemodynamic response","Severe GI upset","Decreased blood pressure","");


        //add random questions to questionsLists
        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        questionsList.add(question11);
        questionsList.add(question12);
        questionsList.add(question13);
        questionsList.add(question14);
        questionsList.add(question15);
        questionsList.add(question16);
        questionsList.add(question17);
        questionsList.add(question18);
        questionsList.add(question19);
        questionsList.add(question20);

        for (int i=0;i<10;i++) {
            QuestionsList rando = questionsList.get(random.nextInt(20));
            randomQuestionList.add(rando);
        }
        return randomQuestionList;
    }

    private static List<QuestionsList> chemistryQuestions() {
        final List<QuestionsList> questionsList = new ArrayList<>();
        List<QuestionsList> randomQuestionList = new ArrayList<>();
        Random random = new Random();

        final QuestionsList question1 = new QuestionsList("Which is the ground-state electronic configuration of chlorine?","1s^22s^22p^8","1s^22s^22p^63s^1","1s^22s^22p^63s^2","1s^22s^22p^6","1s^22s^22p^63s^2","");
        final QuestionsList question2 = new QuestionsList("Which of the following elements is less electronegative than carbon?","Si","N","Cl","Mg2+","Cl","");
        final QuestionsList question3 = new QuestionsList("Which of the following elements is the most electropositive?","Br","Cl","F","I","I","");
        final QuestionsList question4 = new QuestionsList("Which of the following pairs does not show an acid and its conjugate base?","HNO3 and NO3-"," H2SO4 and HSO4-","H2SO4 and SO42-","HSO4- and SO42-","H2SO4 and SO42-","");
        final QuestionsList question5 = new QuestionsList("Which species does not contain an sp3-hybridized atom?","BeH2","BH3","NH3","H30+","BH3","");
        final QuestionsList question6 = new QuestionsList("Which compound is most acidic?","CH4","NH3","H2O","H2S","H2S","");
        final QuestionsList question7 = new QuestionsList("Which compound is least acidic?","FCH2CO2H","ClCH2CO2H","BrCH2CO2H","ICH2CO2H","ICH2CO2H","");
        final QuestionsList question8 = new QuestionsList("Which of the following statements regarding the SN1 mechanism is wrong?","SN1 reactions are unimolecular.","SN1 reactions are first order.","The SN1 mechanism involves a single step.","SN1 reactions usually occur in two steps.","The SN1 mechanism involves a single step.","");
        final QuestionsList question9 = new QuestionsList("Which of the following statements is wrong?","SN1 reactions undergo partial inversion of configuration.","SN2 reactions undergo partial inversion of configuration.","The rate constant of an SN1 reaction depends on the solvent.","The rate constant of an SN2 reaction depends on the solvent."," SN2 reactions undergo partial inversion of configuration.","");
        final QuestionsList question10 = new QuestionsList("Which of the following statements regarding nucleophilicity is wrong?","Ethoxide ion is more nucleophilic than t-butoxide in spite of its lower basicity.","Ethoxide ion is more nucleophilic than t-butoxide due to the lower steric hindrance.","Chloride ion is more nucleophilic than iodide ion because of its higher basicity.","Bromide ion is more nucleophilic than fluoride in spite of its lower basicity.","Chloride ion is more nucleophilic than iodide ion because of its higher basicity.","");
        final QuestionsList question11 = new QuestionsList("Which of the following statements is wrong?","The main orbital interactions in the transition state of an electrophilic addition to an alkene are between the LUMO of the electrophile and the HOMO of the alkene.","The lower the LUMO of the electrophile, the more reactive it is.","The lower the HOMO of the alkene, the more reactive it is.","The electrophile approaches the alkene from above its molecular plane in addition reactions.","The lower the HOMO of the alkene, the more reactive it is.","");
        final QuestionsList question12 = new QuestionsList("Which of the following does not undergo conjugate addition with butanamine?","Propenal","But-2-enal","Ethyl But-3-enoate","Butenone","Ethyl But-3-enoate","");
        final QuestionsList question13 = new QuestionsList("Which of the following does not selectively give the product of conjugate addition with ethyl but-2-enoate?","NaCN / H2O","BuLi / THF","BuNH2","PhSNa / EtOH","BuLi / THF","");
        final QuestionsList question14 = new QuestionsList("Which of (a)-(d) is complementary to the DNA segment 5'-ATGAGCCAT-3'?","5'-TACTCCGTA-3'","5'-TACTCGGTA-3'","5'-TCATCGGTA-3'","5'-TACTGCGTA-3'","5'-TACTCGGTA-3'","");
        final QuestionsList question15 = new QuestionsList("Which naturally occurring α-amino acid is achiral?","glycine","glutamine","leucine","serine","glycine","");
        final QuestionsList question16 = new QuestionsList("Which of the following monosaccharides gives an optically inactive product upon oxidation with HNO3?","D-glucose","D-mannose","D-galactose","D-fructose","D-galactose","");
        final QuestionsList question17 = new QuestionsList("Which is the correct order of increasing wave number of the stretching vibrations of (1) C-H (alkane), (2) O-H (alcohol), (3) C=O (ketone), and (4) C≡C (alkyne)?","(4) < (3) < (2) < (1)","(3) < (4) < (2) < (1)","(4) < (3) < (1) < (2)","(3) < (4) < (1) < (2)","(3) < (4) < (1) < (2)","");
        final QuestionsList question18 = new QuestionsList("How many signals does the aldehyde (CH3)3CCH2CHO have in 1H NMR and 13C NMR spectra?"," five 1H signals and six 13C signals","three 1H signals and four 13C signals","five 1H signals and four 13C signals","hree 1H signals and six 13C signals","three 1H signals and four 13C signals","");
        final QuestionsList question19 = new QuestionsList("Which of the following statements regarding IR spectroscopy is wrong?","Infrared radiation is higher in energy than UV radiation."," Infrared spectra record the transmission of IR radiation.","Molecular vibrations are due to periodic motions of atoms in molecules, and include bond stretching, torsional changes, and bond angle changes.","Infrared spectra give information about bonding features and functional groups in molecules.","Infrared radiation is higher in energy than UV radiation.","");
        final QuestionsList question20 = new QuestionsList("Absorption of radiation in the UV range attributable to n→π* electronic transitions is characteristic of which of the following types of compounds?"," Aromatic hydrocarbons.","Unsaturated carbonyl compounds.","Non-conjugated polyenes.","Conjugated polyenes.","Unsaturated carbonyl compounds.","");

        //add random questions to questionsLists
        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        questionsList.add(question11);
        questionsList.add(question12);
        questionsList.add(question13);
        questionsList.add(question14);
        questionsList.add(question15);
        questionsList.add(question16);
        questionsList.add(question17);
        questionsList.add(question18);
        questionsList.add(question19);
        questionsList.add(question20);

        for (int i=0;i<10;i++) {
            QuestionsList rando = questionsList.get(random.nextInt(20));
            randomQuestionList.add(rando);
        }
        return randomQuestionList;
    }


    public static List<QuestionsList> getQuestions(String selectedTopicName){
        switch (selectedTopicName){
            case "Java":
                return javaQuestions();
            case "Biology":
                return biologyQuestions();
            case "Chemistry":
                return chemistryQuestions();
            case "Cardiology":
                return cardiologyQuestions();
        }
        return null;
    }
}

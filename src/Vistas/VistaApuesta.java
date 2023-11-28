/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.ControladorApuesta;
import Modelo.PokerSinComodin.Notificador;
import Modelo.PokerSinComodin.Observado;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Objects;


/**
 *
 * @author ciro_
 */
public class VistaApuesta extends javax.swing.JFrame implements Observer, VerCartas {

    /**
     * Creates new form VistaApuesta
     */
    public VistaApuesta() {
        initComponents();
    }

    private Integer apuestaMin;
    private Integer fichas;
    private ControladorApuesta controlador;
    private String nombre;

    private Integer totalApostado;

    @Override
    public void update(String str) {
        AreaEventos.append(str);
    }

    @Override
    public void updateApuestaMin(int i) {
        apuestaMin=i;
        apuestaActualTexto.setText(""+apuestaMin);
        botonPasar.setEnabled(Objects.equals(apuestaMin, totalApostado));
    }

    @Override
    public void updateApuestaInicial(int i) {
        totalApostado=i;
        botonPasar.setEnabled(Objects.equals(apuestaMin, totalApostado));
    }

    @Override
    public void updateMontoBote(int i) {
        totalBote.setText(""+i);
    }

    @Override
    public void updateTurnoActual(String nombre) {
        if (Objects.equals(nombre, controlador.nombreJugador())){
            textoTurno.setText("TU TURNO");
            return;
        }
        textoTurno.setText("TURNO: "+nombre);

    }

    @Override
    public void updateJugadores(ArrayList<String> nombres) {

    }

    @Override
    public void updateEtapa(boolean etapaDescarte) {
        this.setVisible(!etapaDescarte);
    }

    @Override
    public void actualizarCartas(ArrayList<String> mensaje) {
        setImagenes(mensaje);
    }

    @Override
    public void actualizarJugada(String jugada) {
        jugadaDelJugador.setText(jugada);
    }

    public void setApuestas(Integer totalApostado){
        this.totalApostado=totalApostado;
        apuestaActualTexto.setText(""+apuestaMin);
        botonPasar.setEnabled(apuestaMin == totalApostado);
        controlador.agregarVerCartas(this);

    }

    public void setApuestaMin(Integer apuestaMin) {
        this.apuestaMin = apuestaMin;
        controlador.agregarMironEventos(this);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        nombreDelJugador.setText(nombre);
    }

    public void setControlador(ControladorApuesta controlador) {
        this.controlador = controlador;
    }

    public void setCantidadeFichas(int fichas){
        this.fichas=fichas;
        fichasJugadorTexto.setText(""+fichas);

    }

    public void setImagenes(ArrayList<String> direcciones){
        imgCarta1.setIcon(new javax.swing.ImageIcon(direcciones.get(0)));
        imgCarta2.setIcon(new javax.swing.ImageIcon(direcciones.get(1)));
        imgCarta3.setIcon(new javax.swing.ImageIcon(direcciones.get(2)));
        imgCarta4.setIcon(new javax.swing.ImageIcon(direcciones.get(3)));
        imgCarta5.setIcon(new javax.swing.ImageIcon(direcciones.get(4)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botonIgualar = new javax.swing.JButton();
        botonPasar = new javax.swing.JButton();
        botonRetirarse = new javax.swing.JButton();
        textoApuesta = new javax.swing.JTextField();
        botonApuesta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        apuestaActualTexto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fichasJugadorTexto = new javax.swing.JLabel();
        textoTurno = new javax.swing.JLabel();
        nombreDelJugador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalBote = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        carta1 = new javax.swing.JPanel();
        imgCarta1 = new javax.swing.JLabel();
        carta2 = new javax.swing.JPanel();
        imgCarta2 = new javax.swing.JLabel();
        carta3 = new javax.swing.JPanel();
        imgCarta3 = new javax.swing.JLabel();
        carta4 = new javax.swing.JPanel();
        imgCarta4 = new javax.swing.JLabel();
        carta5 = new javax.swing.JPanel();
        imgCarta5 = new javax.swing.JLabel();
        jugadaDelJugador = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaEventos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(3, 60, 1));

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apuestas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));

        botonIgualar.setText("Igualar");
        botonIgualar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIgualarActionPerformed(evt);
            }
        });

        botonPasar.setText("Pasar");
        botonPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPasarActionPerformed(evt);
            }
        });

        botonRetirarse.setText("Retirarse");
        botonRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRetirarseActionPerformed(evt);
            }
        });

        textoApuesta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textoApuesta.setText("Cantidad");
        textoApuesta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoApuestaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoApuestaFocusLost(evt);
            }
        });
        textoApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoApuestaActionPerformed(evt);
            }
        });
        textoApuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoApuestaKeyTyped(evt);
            }
        });

        botonApuesta.setText("Apostar");

        botonApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonApuestaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apuesta actual:");

        apuestaActualTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        apuestaActualTexto.setForeground(new java.awt.Color(255, 255, 255));
        apuestaActualTexto.setText("9000");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tus Fichas:");

        fichasJugadorTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        fichasJugadorTexto.setForeground(new java.awt.Color(255, 255, 255));
        fichasJugadorTexto.setText("jLabel5");

        textoTurno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textoTurno.setForeground(new java.awt.Color(255, 255, 255));
        textoTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoTurno.setText("TU TURNO!");

        nombreDelJugador.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nombreDelJugador.setForeground(new java.awt.Color(255, 255, 255));
        nombreDelJugador.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Monto del bote:");

        totalBote.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        totalBote.setForeground(new java.awt.Color(255, 255, 255));
        totalBote.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(nombreDelJugador)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(textoTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(totalBote)
                                                        .addComponent(apuestaActualTexto))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botonRetirarse, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 24, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent(botonApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(49, 49, 49)
                                                                .addComponent(botonPasar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(fichasJugadorTexto))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent(textoApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(60, 60, 60)
                                                                .addComponent(botonIgualar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(textoTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nombreDelJugador))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(botonRetirarse, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(apuestaActualTexto))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(totalBote))))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(textoApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(botonIgualar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(botonApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(botonPasar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(fichasJugadorTexto))
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(9, 68, 7));

        imgCarta1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ciro_\\OneDrive\\Escritorio\\mavenproject1\\src\\main\\java\\Images\\Atras.png")); // NOI18N

        javax.swing.GroupLayout carta1Layout = new javax.swing.GroupLayout(carta1);
        carta1.setLayout(carta1Layout);
        carta1Layout.setHorizontalGroup(
                carta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(carta1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(imgCarta1)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        carta1Layout.setVerticalGroup(
                carta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imgCarta1)
        );

        imgCarta2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ciro_\\OneDrive\\Escritorio\\mavenproject1\\src\\main\\java\\Images\\Atras.png")); // NOI18N

        javax.swing.GroupLayout carta2Layout = new javax.swing.GroupLayout(carta2);
        carta2.setLayout(carta2Layout);
        carta2Layout.setHorizontalGroup(
                carta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carta2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(imgCarta2)
                                .addGap(0, 0, 0))
        );
        carta2Layout.setVerticalGroup(
                carta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imgCarta2)
        );

        imgCarta3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ciro_\\OneDrive\\Escritorio\\mavenproject1\\src\\main\\java\\Images\\Atras.png")); // NOI18N

        javax.swing.GroupLayout carta3Layout = new javax.swing.GroupLayout(carta3);
        carta3.setLayout(carta3Layout);
        carta3Layout.setHorizontalGroup(
                carta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(carta3Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(imgCarta3)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        carta3Layout.setVerticalGroup(
                carta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(carta3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(imgCarta3))
        );

        carta4.setToolTipText("");

        imgCarta4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ciro_\\OneDrive\\Escritorio\\mavenproject1\\src\\main\\java\\Images\\Atras.png")); // NOI18N

        javax.swing.GroupLayout carta4Layout = new javax.swing.GroupLayout(carta4);
        carta4.setLayout(carta4Layout);
        carta4Layout.setHorizontalGroup(
                carta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(carta4Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(imgCarta4)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        carta4Layout.setVerticalGroup(
                carta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(carta4Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(imgCarta4)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        imgCarta5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ciro_\\OneDrive\\Escritorio\\mavenproject1\\src\\main\\java\\Images\\Atras.png")); // NOI18N

        javax.swing.GroupLayout carta5Layout = new javax.swing.GroupLayout(carta5);
        carta5.setLayout(carta5Layout);
        carta5Layout.setHorizontalGroup(
                carta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(carta5Layout.createSequentialGroup()
                                .addComponent(imgCarta5)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        carta5Layout.setVerticalGroup(
                carta5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(carta5Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(imgCarta5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jugadaDelJugador = new javax.swing.JLabel();

        jugadaDelJugador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jugadaDelJugador.setForeground(new java.awt.Color(255, 255, 255));

        jugadaDelJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jugadaDelJugador.setText("jLabel5");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(carta4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(carta5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(257, 257, 257)
                                                .addComponent(jugadaDelJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(12, Short.MAX_VALUE)
                                .addComponent(jugadaDelJugador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(carta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(carta5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(carta2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(carta1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(20, 7));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(20, 7));

        AreaEventos.setEditable(false);
        AreaEventos.setBackground(new java.awt.Color(51, 51, 51));
        AreaEventos.setColumns(20);
        AreaEventos.setForeground(new java.awt.Color(255, 255, 255));
        AreaEventos.setRows(5);
        jScrollPane1.setViewportView(AreaEventos);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(301, 301, 301)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void botonPasarActionPerformed(java.awt.event.ActionEvent evt) {

        controlador.recibirApuesta(0);

    }

    private void botonIgualarActionPerformed(java.awt.event.ActionEvent evt) {


        controlador.recibirApuesta((apuestaMin));
        totalApostado=apuestaMin;
        textoApuesta.setText("Cantidad");

    }
    private void botonRetirarseActionPerformed(java.awt.event.ActionEvent evt) {

        controlador.recibirApuesta(-1);
        textoApuesta.setText("Cantidad");

    }



    private void botonApuestaActionPerformed(java.awt.event.ActionEvent evt) {
        String apuesta= textoApuesta.getText();
        if (!Objects.equals(apuesta, "") && !Objects.equals(apuesta, "Cantidad")){
            int numero=Integer.parseInt(apuesta);
            if(numero>=apuestaMin){
                totalApostado=numero;
                controlador.recibirApuesta(numero);
                textoApuesta.setText("Cantidad");

            }
        }
    }


    private void textoApuestaActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private void textoApuestaKeyTyped(java.awt.event.KeyEvent evt) {
        Character c= evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }
    }


    private void textoApuestaFocusGained(java.awt.event.FocusEvent evt) {
        if (Objects.equals(textoApuesta.getText(), "Cantidad")){
            textoApuesta.setText("");
        }
    }
    private void textoApuestaFocusLost(java.awt.event.FocusEvent evt) {
        if (Objects.equals(textoApuesta.getText(), "")){
            textoApuesta.setText("Cantidad");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaApuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaApuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaApuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaApuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaApuesta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextArea AreaEventos;
    private javax.swing.JLabel apuestaActualTexto;
    private javax.swing.JButton botonApuesta;
    private javax.swing.JButton botonIgualar;
    private javax.swing.JButton botonPasar;
    private javax.swing.JButton botonRetirarse;
    private javax.swing.JPanel carta1;
    private javax.swing.JPanel carta2;
    private javax.swing.JPanel carta3;
    private javax.swing.JPanel carta4;
    private javax.swing.JPanel carta5;
    private javax.swing.JLabel fichasJugadorTexto;
    private javax.swing.JLabel imgCarta1;
    private javax.swing.JLabel imgCarta2;
    private javax.swing.JLabel imgCarta3;
    private javax.swing.JLabel imgCarta4;
    private javax.swing.JLabel imgCarta5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jugadaDelJugador;
    private javax.swing.JLabel nombreDelJugador;
    private javax.swing.JTextField textoApuesta;
    private javax.swing.JLabel textoTurno;
    private javax.swing.JLabel totalBote;
    // End of variables declaration
}

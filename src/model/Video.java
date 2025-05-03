package model;

import dto.input.VideoOmdb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Video {
    private String nome;
    private int anoDeLancamento;
    private List<String> genero;
    private Double duracaoMinutos;

    public Video(String nome, int anoDeLancamento, String genero, Double duracao) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.genero.add(genero);
        this.duracaoMinutos = duracao;
    }
    public Video(){}
    public Video(VideoOmdb videoOmdb) {
        this.nome = videoOmdb.title();

        this.anoDeLancamento = parseInt(videoOmdb.year());

        String[] array = videoOmdb.genre().split(",\\s*");
        this.genero =  new ArrayList<>();
        Collections.addAll(this.genero, array);

        this.duracaoMinutos = parseDouble(videoOmdb.runtime().replaceFirst("[^\\d.]", ""));
    }

    @Override
    public String toString() {
        return "Video{" +
                "titulo:" + this.nome + ", " +
                "ano:" + this.anoDeLancamento + ", " +
                "genero:" + this.genero + ", " +
                "duração:" + this.duracaoMinutos + "}";
    }

}

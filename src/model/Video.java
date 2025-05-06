package model;

import dto.input.VideoOmdb;
import model.error.ErrorDeConversao;

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
        if(videoOmdb.year().length() > 4) {
            throw new ErrorDeConversao("Formato de ano errado");
        } else {
            this.anoDeLancamento = parseInt(videoOmdb.year());
        }


        String[] array = videoOmdb.genre().split(",\\s*");
        this.genero =  new ArrayList<>();
        Collections.addAll(this.genero, array);

        String[] partes = videoOmdb.runtime().split(" ");
        if(partes.length == 1) {
            throw new ErrorDeConversao("Erro, formato de runtime invalido");
        }
        this.duracaoMinutos = parseDouble(partes[0]);
    }

    @Override
    public String toString() {
        return "( Video{" +
                "titulo:" + this.nome + ", " +
                "ano:" + this.anoDeLancamento + ", " +
                "genero:" + this.genero + ", " +
                "duração:" + this.duracaoMinutos + "}) ";
    }

}

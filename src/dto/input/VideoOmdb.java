package dto.input;

public record VideoOmdb(
        String title,
        String year,
        String released,
        String runtime,
        String genre
) {
}

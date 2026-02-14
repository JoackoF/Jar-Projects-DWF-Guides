package sv.edu.udb.service;

public interface TransferService {
    Double transfer(final Integer userId1,
                  final Integer userId2,
                  final Double amount);

}

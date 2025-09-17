package unicam.filierafanesicardinali.controller.DTO;

import java.time.LocalDateTime;

public record InvitationDto(
        Long userId,
        LocalDateTime expiry
) {
}

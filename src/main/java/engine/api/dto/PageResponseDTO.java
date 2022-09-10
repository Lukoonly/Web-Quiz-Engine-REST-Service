package engine.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class PageResponseDTO {
    private int totalPages;
    private int totalElements;
    private List<PageDTO> content;
}
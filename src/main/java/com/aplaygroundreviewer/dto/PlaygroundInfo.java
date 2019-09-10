package com.aplaygroundreviewer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaygroundInfo {
    public String playgroundName;
    public String playgroundAddress;
    public String url;
}

package com.aplaygroundreviewer.dto;

import lombok.Builder;
import lombok.Data;
//for implementing take google map playgrounds from database
@Data
@Builder
public class PlaygroundInfo {
    public String playgroundName;
    public String playgroundAddress;
    public String url;
    public String milesFromZip;

}

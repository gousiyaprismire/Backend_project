package com.universtiy.service;

import com.university.model.Study_Options;
import java.util.List;

public interface Study_OptionsService {

    Study_Options createStudyOption(Study_Options studyOption);

    List<Study_Options> getAllStudyOptions();

    List<Study_Options> getStudyOptionsByLevel(String level);
}

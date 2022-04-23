package com.arcane.app.repository;

import com.arcane.app.domain.Tag;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface TagRepositoryWithBagRelationships {
    Optional<Tag> fetchBagRelationships(Optional<Tag> tag);

    List<Tag> fetchBagRelationships(List<Tag> tags);

    Page<Tag> fetchBagRelationships(Page<Tag> tags);
}

package com.example.demo.domain.mappers;

import com.example.demo.domain.entities.PostEntity;
import com.example.demo.infrastructure.Post.PostDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostEntity mapToEntity(PostDto postDto);
    PostDto mapToDto(PostEntity postEntity);

    List<PostDto> mapListToDto(List<PostEntity> postEntities);
}

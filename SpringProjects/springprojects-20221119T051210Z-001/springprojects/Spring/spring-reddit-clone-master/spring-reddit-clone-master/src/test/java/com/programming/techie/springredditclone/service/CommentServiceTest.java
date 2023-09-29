package com.programming.techie.springredditclone.service;

import com.programming.techie.springredditclone.exceptions.SpringRedditException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommentServiceTest {

    @Test
    @DisplayName("Test Should Pass When Comment do not Contains Swear Words")//this annotation is used to specify the functionality of
    void shouldNotContainSwearWordsInsideComment()   //test method
    {
        CommentService commentService = new CommentService(null, null, null, null, null, null, null);
        assertThat(commentService.containsSwearWords("This is a comment")).isFalse();
       // Assertions.assertFalse(commentService.containsSwearWords("this is clean comment"));
    }

    @Test
    @DisplayName("Should Throw Exception when Exception Contains Swear Words")
    void shouldFailWhenCommentContainsSwearWords() {
        CommentService commentService = new CommentService(null, null, null, null, null, null, null);

        assertThatThrownBy(() -> {
            commentService.containsSwearWords("This is a shitty comment");
        }).isInstanceOf(SpringRedditException.class)
                .hasMessage("Comments contains unacceptable language");
    }
}



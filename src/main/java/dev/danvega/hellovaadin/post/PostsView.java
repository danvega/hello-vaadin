package dev.danvega.hellovaadin.post;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import java.util.List;


@Route("posts")
class PostsView extends Div {


    public PostsView(PostService postService) {
        setHeightFull();
        Grid<Post> grid = new Grid<>(Post.class, false);
        grid.addColumn(Post::title).setHeader("Title");
        grid.addColumn(Post::summary).setHeader("Summary");
        grid.addColumn(Post::url).setHeader("URL");
        grid.addColumn(Post::datePublished).setHeader("Date Published");
        grid.addColumn(p->p.author().name()).setHeader("Author");
        grid.addThemeVariants(GridVariant.LUMO_COMPACT);
        grid.setHeightFull();
        List<Post> posts = postService.findAll();
        grid.setItems(posts);

        add(grid);
    }

}
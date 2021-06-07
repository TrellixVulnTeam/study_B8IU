package kr.or.ddit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	@Autowired
	BookService bookService;

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam Map<String, Object> map) {
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Boolean> errors = new HashMap<String, Boolean>();

		String title = map.get("title").toString();
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}

		String category = map.get("category").toString();
		if (category == null || category.trim().isEmpty()) {
			errors.put("category", Boolean.TRUE);
		}

		String price = map.get("price").toString();
		if (price == null || price.trim().isEmpty()) {
			errors.put("price", Boolean.TRUE);
		}

		if (errors.isEmpty()) {
			String bookId = bookService.create(map);

			if (bookId == null) {
				modelAndView.setViewName("redirect://create");
			} else {
				modelAndView.setViewName("redirect:/detail?bookId=" + bookId);
			}
		} else {
			modelAndView = create(map);
			modelAndView.addObject("errors", errors);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = bookService.detail(map);
		String bookId = map.get("bookId").toString();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("data", detailMap);
		System.out.println(detailMap);
		modelAndView.addObject("bookId", bookId);
		modelAndView.setViewName("/book/detail");

		return modelAndView;
	}

	@RequestMapping(path = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		ModelAndView detailModelAndView = detail(map);
		detailModelAndView.setViewName("/book/update");

		return detailModelAndView;
	}

	@RequestMapping(path = "update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Boolean> errors = new HashMap<String, Boolean>();

		String title = map.get("title").toString();
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}

		String category = map.get("category").toString();
		if (category == null || category.trim().isEmpty()) {
			errors.put("category", Boolean.TRUE);
		}

		String price = map.get("price").toString();
		if (price == null || price.trim().isEmpty()) {
			errors.put("price", Boolean.TRUE);
		}

		if (errors.isEmpty()) {
			if (bookService.edit(map)) {
				String bookId = map.get("bookId").toString();
				modelAndView.setViewName("redirect:/detail?bookId=" + bookId);
			} else {
				modelAndView = update(map);
			}
		} else {
			modelAndView = update(map);
			modelAndView.addObject("errors", errors);
		}

		return modelAndView;
	}

	@RequestMapping(path = "delete", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {
		ModelAndView modelAndView = new ModelAndView();
		if (bookService.remove(map)) {
			modelAndView.setViewName("redirect:/list");
		} else {
			String bookId = map.get("bookId").toString();
			modelAndView.setViewName("redirect:/detail?bookId=" + bookId);
		}

		return modelAndView;
	}

	@RequestMapping(path = "list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		List<Map<String, Object>> list = bookService.list(map);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("data", list);

		if (map.containsKey("keyword")) {
			modelAndView.addObject("keyword", map.get("keyword"));
		}

		modelAndView.setViewName("/book/list");

		return modelAndView;
	}
}

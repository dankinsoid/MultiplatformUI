import SwiftUI
import Shared

struct ContentView: UI {
	let greet = Greeting().greeting()

	var body: some UI {
        Text(greet).onAppear {
            print(
                UIHostingController(
                    rootView: Text("100")
                ).view.systemLayoutSizeFitting(
                    CGSize(width: 50, height: CGFloat.infinity),
                    withHorizontalFittingPriority: .required,
                    verticalFittingPriority: .defaultLow
                )
            )
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some UI {
		ContentView()
	}
}

final class SwiftUIKotlinUIProvider: KotlinUIProvider {
    
    func makeEmpty(context: KotlinUIProviderContext) -> KotlinUIComponent {
        SwiftUIWrapper(.empty)
    }
    
    func makeText(text: String, context: KotlinUIProviderContext) -> KotlinUIComponent {
        SwiftUIWrapper(.text(text))
    }
    
    func makeLayout(subviews: [KotlinUILayoutSubview], context: KotlinUIProviderContext) -> KotlinUIComponent {
        SwiftUIWrapper(.layout(subviews))
    }
}

enum KotlinUIView: UI {
    
    case empty
    case text(String)
    case layout([KotlinUILayoutSubview])
    
    var body: some UI {
        Group {
            switch self {
            case .empty:
                Color.clear
            case let .text(text):
                Text(text)
            case let .layout(subviews):
                LayoutView(subviews: subviews)
            }
        }
    }
}

extension KotlinUILayoutSubview: Identifiable {
}

struct LayoutView: UI {
    
    let subviews: [KotlinUILayoutSubview]
    
    var body: some UI {
        ZStack {
            ForEach(subviews) { subview in
                if let content = (subview.element as? SwiftUIWrapper) {
                    content
                        .controller
                        .rootView
                        .frame(
                            width: subview.frame.size.width,
                            height: subview.frame.size.height
                        )
                        .offset(
                            x: subview.frame.origin.x,
                            y: subview.frame.origin.y
                        )
                }
            }
        }
    }
}

final class SwiftUIWrapper: KotlinUIComponent {
    
    let controller: UIHostingController<KotlinUIView>
    
    init(_ content: KotlinUIView) {
        controller = UIHostingController(rootView: content)
    }
    
    func size(proposal: ProposedUISize) ->  {
        controller.view.size(proposal: proposal)
    }
}

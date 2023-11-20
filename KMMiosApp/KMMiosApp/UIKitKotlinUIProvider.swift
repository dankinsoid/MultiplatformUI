import UIKit
import Shared

public final class UIKitKotlinUIProvider: KotlinUIProvider {
    
    public func makeEmpty(context: KotlinUIProviderContext) -> KotlinUIComponent {
        context.cache ?? UIView()
    }
    
    public func makeLayout(subviews: [KotlinUILayoutSubview], context: KotlinUIProviderContext) -> KotlinUIComponent {
        let element = makeEmpty(context: context)
        guard let view = element as? UIView else { return element }
        var old = Set(view.subviews)
        for subview in subviews {
            guard let asView = subview.element as? UIView else {
                continue
            }
            if old.contains(asView) {
                old.remove(asView)
            } else {
                view.addSubview(asView)
            }
            asView.frame = subview.frame.cg
        }
        old.forEach {
            $0.removeFromSuperview()
        }
        return view
    }
    
    public func makeText(text: String, context: KotlinUIProviderContext) -> KotlinUIComponent {
        let label = (context.cache as? UILabel) ?? UILabel()
        label.text = text
        return label
    }
}

extension UIView: KotlinUIComponent {
    
    public func sizeThatFits(proposal: ProposedUISize) -> UISize {
        let size = systemLayoutSizeFitting(
            CGSize(
                width: proposal.width?.doubleValue ?? UIView.layoutFittingCompressedSize.width,
                height: proposal.height?.doubleValue ?? UIView.layoutFittingExpandedSize.height
            ),
            withHorizontalFittingPriority: proposal.width == nil ? .defaultLow : .required,
            verticalFittingPriority: proposal.height == nil ? .defaultLow : .required
        )
        return UISize(
            width: size.width,
            height: size.height
        )
    }
}

public extension UIRect {
    
    var cg: CGRect {
        CGRect(origin: origin.cg, size: size.cg)
    }
}

public extension UIPoint {
    
    var cg: CGPoint {
        CGPoint(x: x, y: y)
    }
}

public extension UISize {
    
    var cg: CGSize {
        CGSize(width: width, height: height)
    }
}

import UIKit
import shared

public final class UIKitKotlinUIProvider: KotlinUIProvider {
    
    public func makeLayout(subviews: [KotlinUILayoutSubview], context: KotlinUIProviderContext) -> KotlinUILayout {
        let element = makeEmpty(context: context)
        guard let view = element as? UIView else { return UIView() }
        var old = Set(view.subviews)
        for subview in subviews {
            guard let asView = subview.component as? UIView else {
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

    public func makeButton(context: KotlinUIProviderContext) -> KotlinUIComponent {
        UIButton()
    }
    
    public func makeText(context: KotlinUIProviderContext) -> KotlinUIComponent {
        let label = (context.component as? UILabel) ?? UILabel()
//        label.text = context.enviro
        return label
    }
    
    public func makeEmpty(context: KotlinUIProviderContext) -> KotlinUIComponent {
        (context.component as? UIView) ?? UIView()
    }
}

extension UIView: KotlinUILayout {
    
    public func placeSubviewsIn(bounds: UIRect, proposal: ProposedUISize, subviews: [KotlinUILayoutSubview]) {
    }
    
    public func update(context: KotlinUIProviderContext) {
    }
    
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

package vaadin.scala

import vaadin.scala.internal.LayoutClickListener
import vaadin.scala.internal.ListenersTrait

case class LayoutClickEvent(component: Component, clickedComponent: Component, childComponent: Component, button: MouseButton.Value, clientX: Int, clientY: Int, relativeX: Int, relativeY: Int, doubleClick: Boolean, altKey: Boolean, ctrlKey: Boolean, metaKey: Boolean, shiftKey: Boolean) extends AbstractClickEvent(component, button, clientX, clientY, relativeX, relativeY, doubleClick, altKey, ctrlKey, metaKey, shiftKey)

trait LayoutClickNotifier { self: { def p: com.vaadin.ui.AbstractLayout with com.vaadin.event.LayoutEvents.LayoutClickNotifier; } =>
  lazy val layoutClickListeners = new ListenersTrait[LayoutClickEvent, LayoutClickListener] {
    override def listeners = p.getListeners(classOf[com.vaadin.event.LayoutEvents.LayoutClickEvent])
    override def addListener(elem: LayoutClickEvent => Unit) = p.addLayoutClickListener(new LayoutClickListener(elem))
    override def removeListener(elem: LayoutClickListener) = p.removeLayoutClickListener(elem)
  }
}
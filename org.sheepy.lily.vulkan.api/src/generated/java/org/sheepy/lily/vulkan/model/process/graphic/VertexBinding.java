/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertex Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.VertexBinding#getBufferRef <em>Buffer Ref</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getVertexBinding()
 * @model
 * @generated
 */
public interface VertexBinding extends EObject
{
	/**
	 * Returns the value of the '<em><b>Buffer Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Ref</em>' containment reference.
	 * @see #setBufferRef(IBufferReference)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getVertexBinding_BufferRef()
	 * @model containment="true"
	 * @generated
	 */
	IBufferReference getBufferRef();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.VertexBinding#getBufferRef <em>Buffer Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Ref</em>' containment reference.
	 * @see #getBufferRef()
	 * @generated
	 */
	void setBufferRef(IBufferReference value);

} // VertexBinding

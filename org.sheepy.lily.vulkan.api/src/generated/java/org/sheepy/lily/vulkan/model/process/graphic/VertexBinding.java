/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.vulkan.model.resource.IBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertex Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.VertexBinding#getBuffer <em>Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getVertexBinding()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface VertexBinding extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' reference.
	 * @see #setBuffer(IBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getVertexBinding_Buffer()
	 * @model resolveProxies="false"
	 * @generated
	 */
	IBuffer getBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.VertexBinding#getBuffer <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(IBuffer value);

} // VertexBinding

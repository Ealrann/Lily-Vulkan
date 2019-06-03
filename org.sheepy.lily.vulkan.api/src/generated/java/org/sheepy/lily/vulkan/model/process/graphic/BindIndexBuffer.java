/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.resource.IBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bind Index Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBindIndexBuffer()
 * @model
 * @generated
 */
public interface BindIndexBuffer extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' reference.
	 * @see #setBuffer(IBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBindIndexBuffer_Buffer()
	 * @model required="true"
	 * @generated
	 */
	IBuffer getBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getBuffer <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(IBuffer value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(long)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBindIndexBuffer_Offset()
	 * @model default="0" unique="false"
	 * @generated
	 */
	long getOffset();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(long value);

} // BindIndexBuffer

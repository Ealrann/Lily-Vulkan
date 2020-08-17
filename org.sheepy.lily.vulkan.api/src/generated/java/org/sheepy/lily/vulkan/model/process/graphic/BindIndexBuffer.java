/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.vulkan.model.enumeration.EIndexType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bind Index Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getIndexType <em>Index Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getBuffer <em>Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBindIndexBuffer()
 * @model
 * @generated
 */
public interface BindIndexBuffer extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Index Type</b></em>' attribute.
	 * The default value is <code>"UINT32"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EIndexType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EIndexType
	 * @see #setIndexType(EIndexType)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBindIndexBuffer_IndexType()
	 * @model default="UINT32" unique="false"
	 * @generated
	 */
	EIndexType getIndexType();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getIndexType <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EIndexType
	 * @see #getIndexType()
	 * @generated
	 */
	void setIndexType(EIndexType value);

	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' reference.
	 * @see #setBuffer(IBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBindIndexBuffer_Buffer()
	 * @model resolveProxies="false"
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

} // BindIndexBuffer

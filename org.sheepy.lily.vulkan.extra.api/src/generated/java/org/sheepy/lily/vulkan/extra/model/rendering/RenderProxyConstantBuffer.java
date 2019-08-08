/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Render Proxy Constant Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer#getConstantBuffer <em>Constant Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer#getPartIndex <em>Part Index</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderProxyConstantBuffer()
 * @model
 * @generated
 */
public interface RenderProxyConstantBuffer extends ConstantBuffer
{
	/**
	 * Returns the value of the '<em><b>Constant Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Buffer</em>' reference.
	 * @see #setConstantBuffer(ConstantBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderProxyConstantBuffer_ConstantBuffer()
	 * @model required="true"
	 * @generated
	 */
	ConstantBuffer getConstantBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer#getConstantBuffer <em>Constant Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Buffer</em>' reference.
	 * @see #getConstantBuffer()
	 * @generated
	 */
	void setConstantBuffer(ConstantBuffer value);

	/**
	 * Returns the value of the '<em><b>Part Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Index</em>' attribute.
	 * @see #setPartIndex(int)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderProxyConstantBuffer_PartIndex()
	 * @model required="true"
	 * @generated
	 */
	int getPartIndex();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer#getPartIndex <em>Part Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Index</em>' attribute.
	 * @see #getPartIndex()
	 * @generated
	 */
	void setPartIndex(int value);

} // RenderProxyConstantBuffer

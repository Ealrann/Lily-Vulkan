/**
 */
package org.sheepy.lily.vulkan.extra.nuklear.model;

import org.sheepy.lily.vulkan.model.process.graphic.IGUIPipeline;

import org.sheepy.lily.vulkan.model.resource.Font;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getFont <em>Font</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getPushConstant <em>Push Constant</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getSubpass <em>Subpass</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#getNuklearPipeline()
 * @model
 * @generated
 */
public interface NuklearPipeline extends IGUIPipeline
{
	/**
	 * Returns the value of the '<em><b>Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' containment reference.
	 * @see #setFont(Font)
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#getNuklearPipeline_Font()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Font getFont();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getFont <em>Font</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' containment reference.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(Font value);

	/**
	 * Returns the value of the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Push Constant</em>' containment reference.
	 * @see #setPushConstant(NuklearConstants)
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#getNuklearPipeline_PushConstant()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NuklearConstants getPushConstant();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getPushConstant <em>Push Constant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Push Constant</em>' containment reference.
	 * @see #getPushConstant()
	 * @generated
	 */
	void setPushConstant(NuklearConstants value);

	/**
	 * Returns the value of the '<em><b>Subpass</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subpass</em>' attribute.
	 * @see #setSubpass(int)
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#getNuklearPipeline_Subpass()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getSubpass();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getSubpass <em>Subpass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subpass</em>' attribute.
	 * @see #getSubpass()
	 * @generated
	 */
	void setSubpass(int value);

} // NuklearPipeline

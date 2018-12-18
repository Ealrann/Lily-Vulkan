/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subpass Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcSubpass <em>Src Subpass</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstSubpass <em>Dst Subpass</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcStageMask <em>Src Stage Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstStageMask <em>Dst Stage Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcAccessMask <em>Src Access Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstAccessMask <em>Dst Access Mask</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency()
 * @model
 * @generated
 */
public interface SubpassDependency extends EObject
{
	/**
	 * Returns the value of the '<em><b>Src Subpass</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Subpass</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Subpass</em>' attribute.
	 * @see #setSrcSubpass(int)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_SrcSubpass()
	 * @model default="-1" unique="false"
	 * @generated
	 */
	int getSrcSubpass();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcSubpass <em>Src Subpass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Subpass</em>' attribute.
	 * @see #getSrcSubpass()
	 * @generated
	 */
	void setSrcSubpass(int value);

	/**
	 * Returns the value of the '<em><b>Dst Subpass</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Subpass</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Subpass</em>' attribute.
	 * @see #setDstSubpass(int)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_DstSubpass()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getDstSubpass();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstSubpass <em>Dst Subpass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Subpass</em>' attribute.
	 * @see #getDstSubpass()
	 * @generated
	 */
	void setDstSubpass(int value);

	/**
	 * Returns the value of the '<em><b>Src Stage Mask</b></em>' attribute.
	 * The default value is <code>"COLOR_ATTACHMENT_OUTPUT_BIT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Stage Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Stage Mask</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setSrcStageMask(EPipelineStage)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_SrcStageMask()
	 * @model default="COLOR_ATTACHMENT_OUTPUT_BIT" unique="false"
	 * @generated
	 */
	EPipelineStage getSrcStageMask();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcStageMask <em>Src Stage Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Stage Mask</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getSrcStageMask()
	 * @generated
	 */
	void setSrcStageMask(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Dst Stage Mask</b></em>' attribute.
	 * The default value is <code>"COLOR_ATTACHMENT_OUTPUT_BIT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Stage Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Stage Mask</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setDstStageMask(EPipelineStage)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_DstStageMask()
	 * @model default="COLOR_ATTACHMENT_OUTPUT_BIT" unique="false"
	 * @generated
	 */
	EPipelineStage getDstStageMask();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstStageMask <em>Dst Stage Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Stage Mask</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getDstStageMask()
	 * @generated
	 */
	void setDstStageMask(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Src Access Mask</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Access Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Access Mask</em>' attribute.
	 * @see #setSrcAccessMask(int)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_SrcAccessMask()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getSrcAccessMask();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcAccessMask <em>Src Access Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Access Mask</em>' attribute.
	 * @see #getSrcAccessMask()
	 * @generated
	 */
	void setSrcAccessMask(int value);

	/**
	 * Returns the value of the '<em><b>Dst Access Mask</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Access Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Access Mask</em>' attribute.
	 * @see #setDstAccessMask(int)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getSubpassDependency_DstAccessMask()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getDstAccessMask();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstAccessMask <em>Dst Access Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Access Mask</em>' attribute.
	 * @see #getDstAccessMask()
	 * @generated
	 */
	void setDstAccessMask(int value);

} // SubpassDependency

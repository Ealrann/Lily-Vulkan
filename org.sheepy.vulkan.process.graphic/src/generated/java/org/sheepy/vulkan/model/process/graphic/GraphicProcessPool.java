/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.sheepy.vulkan.model.IGraphicProcessPool;

import org.sheepy.vulkan.model.process.AbstractProcessPool;
import org.sheepy.vulkan.model.resource.DepthImage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Pool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getRenderPassInfo <em>Render Pass Info</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getDepthImage <em>Depth Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicProcessPool()
 * @model
 * @generated
 */
public interface GraphicProcessPool extends AbstractProcessPool<GraphicProcess>, IGraphicProcessPool
{
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(GraphicConfiguration)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicProcessPool_Configuration()
	 * @model containment="true"
	 * @generated
	 */
	GraphicConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(GraphicConfiguration value);

	/**
	 * Returns the value of the '<em><b>Render Pass Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Render Pass Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Render Pass Info</em>' containment reference.
	 * @see #setRenderPassInfo(RenderPassInfo)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicProcessPool_RenderPassInfo()
	 * @model containment="true"
	 * @generated
	 */
	RenderPassInfo getRenderPassInfo();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getRenderPassInfo <em>Render Pass Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Pass Info</em>' containment reference.
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	void setRenderPassInfo(RenderPassInfo value);

	/**
	 * Returns the value of the '<em><b>Depth Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth Image</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth Image</em>' containment reference.
	 * @see #setDepthImage(DepthImage)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getGraphicProcessPool_DepthImage()
	 * @model containment="true"
	 * @generated
	 */
	DepthImage getDepthImage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getDepthImage <em>Depth Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth Image</em>' containment reference.
	 * @see #getDepthImage()
	 * @generated
	 */
	void setDepthImage(DepthImage value);

} // GraphicProcessPool

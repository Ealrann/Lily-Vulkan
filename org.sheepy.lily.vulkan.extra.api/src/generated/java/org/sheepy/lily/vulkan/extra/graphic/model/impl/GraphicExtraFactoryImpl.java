/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.extra.graphic.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicExtraFactoryImpl extends EFactoryImpl implements GraphicExtraFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphicExtraFactory init()
	{
		try
		{
			GraphicExtraFactory theGraphicExtraFactory = (GraphicExtraFactory) EPackage.Registry.INSTANCE
					.getEFactory(GraphicExtraPackage.eNS_URI);
			if (theGraphicExtraFactory != null)
			{
				return theGraphicExtraFactory;
			}
		} catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphicExtraFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicExtraFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
		case GraphicExtraPackage.IMAGE_PIPELINE:
			return createImagePipeline();
		case GraphicExtraPackage.MESH_RENDERER:
			return createMeshRenderer();
		case GraphicExtraPackage.SCREEN_RENDERER:
			return createScreenRenderer();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImagePipeline createImagePipeline()
	{
		ImagePipelineImpl imagePipeline = new ImagePipelineImpl();
		return imagePipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MeshRenderer createMeshRenderer()
	{
		MeshRendererImpl meshRenderer = new MeshRendererImpl();
		return meshRenderer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScreenRenderer createScreenRenderer()
	{
		ScreenRendererImpl screenRenderer = new ScreenRendererImpl();
		return screenRenderer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicExtraPackage getGraphicExtraPackage()
	{
		return (GraphicExtraPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphicExtraPackage getPackage()
	{
		return GraphicExtraPackage.eINSTANCE;
	}

} //GraphicExtraFactoryImpl
